package com.edkim.core.config.feign;

import com.edkim.core.exception.CommonException;
import com.edkim.core.wrapper.ResultResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;
import static java.time.temporal.ChronoField.INSTANT_SECONDS;

@Log4j2
@NoArgsConstructor
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        // 400, 401 에러시 에러 메시지 자체를 프론트로 보냄
        if( response.status() == 400 || response.status() == 401 ){
            try {
                ResultResponse result = new ObjectMapper().readValue(response.body().toString(), ResultResponse.class);
                return new CommonException(HttpStatus.valueOf(response.status()), result.getCode(), result.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (isRetry(response)) {
            OffsetDateTime offsetDateTime = OffsetDateTime.now().plusSeconds(5L);
            Date retryAfter = new Date(TimeUnit.SECONDS.toMillis(offsetDateTime.getLong(INSTANT_SECONDS)));
            return new RetryableException(response.status(), format("%s 요청이 성공하지 못했습니다. - status: %s, headers: %s", methodKey, response.status(), response.headers()), response.request().httpMethod(), retryAfter, response.request());
        }

        return new IllegalStateException(format("%s 요청이 성공하지 못했습니다. Retry 합니다. - cause: %s, headers: %s", methodKey, response.status(), response.headers()));
    }

    private boolean isRetry(Response response) {
        if (response.request().httpMethod().name().equals(HttpMethod.GET.name())) {
            return true;//HttpStatusClass.SERVER_ERROR.contains(response.status());
        }
        return false;
    }
}
