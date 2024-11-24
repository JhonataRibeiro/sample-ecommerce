package com.jra.sampleecommerce.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class RestApiErrorHandler {

    private final MessageSource messageSource;

    @Autowired
    public RestApiErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<com.jra.sampleecommerce.exception.Error> handleException(HttpServletRequest
                                                         request, Exception ex, Locale locale) {
        com.jra.sampleecommerce.exception.Error error = com.jra.sampleecommerce.exception.ErrorUtils.createError(
                com.jra.sampleecommerce.exception.ErrorCode.GENERIC_ERROR.
                        getErrMsgKey(), com.jra.sampleecommerce.exception.ErrorCode.GENERIC_ERROR.getErrCode(), HttpStatus.
                        INTERNAL_SERVER_ERROR.value()
        );

        error.setUrl(request.getRequestURL().toString());
        error.setReqMethod(request.getMethod());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<com.jra.sampleecommerce.exception.Error>
    handleHttpMediaTypeNotSupportedException(
            HttpServletRequest request,
            HttpMediaTypeNotSupportedException ex, Locale locale) {
        Error error = ErrorUtils
                .createError(com.jra.sampleecommerce.exception.ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getErrMsgKey(),
                        ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getErrCode(),
                        HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());


        error.setUrl(request.getRequestURL().toString());
        error.setReqMethod(request.getMethod());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
