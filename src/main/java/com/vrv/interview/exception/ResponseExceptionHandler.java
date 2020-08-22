package com.vrv.interview.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 异常处理
 *
 * @author hycao
 */
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 一般性错误
     */
    @ExceptionHandler(value = com.vrv.interview.exception.GeneralException.class)
    protected ResponseEntity<Object> handleGeneralException(RuntimeException e, WebRequest webRequest) {
        return handleExceptionInternal(e, e.getMessage(),
            new HttpHeaders(),
            HttpStatus.BAD_REQUEST,
            webRequest);
    }

}
