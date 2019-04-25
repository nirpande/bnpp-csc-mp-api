package com.bnp.csc.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionResolver {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ApiErrorResponse handleException( HttpServletRequest request, Exception e) {
        return ApiErrorResponse
                .ApiErrorResponseBuilder
                .anApiErrorResponse()
                .withCode( ErrorConstants.ERROR_E100001 )
                .withMessage( e.getMessage() )
                .withStatus( HttpStatus.BAD_REQUEST )
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ApiErrorResponse handleException( HttpServletRequest request, MissingServletRequestParameterException e ){
        return ApiErrorResponse
                .ApiErrorResponseBuilder
                .anApiErrorResponse()
                .withCode( ErrorConstants.ERROR_E100002 )
                .withMessage( e.getMessage() )
                .withStatus( HttpStatus.BAD_REQUEST )
                .build();
    }
}
