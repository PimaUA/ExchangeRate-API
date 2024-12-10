package com.currency.exchange.exception.handler;

import com.currency.exchange.dto.exception.ErrorDto;
import com.currency.exchange.exception.customexceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InactiveAccountException.class)
    public ResponseEntity<?> inactiveAccountExceptionHandler(InactiveAccountException inactiveAccountException) {
        ErrorDto errorDto = new ErrorDto("error", "inactive-account");
        return new ResponseEntity<>(errorDto, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(InvalidKeyException.class)
    public ResponseEntity<?> invalidKeyExceptionHandler(InvalidKeyException invalidKeyException) {
        ErrorDto errorDto = new ErrorDto("error", "invalid-key");
        return new ResponseEntity<>(errorDto, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MalformedRequestException.class)
    public ResponseEntity<ErrorDto> handleMalformedRequestException(MalformedRequestException malformedRequestException) {
        ErrorDto errorDto = new ErrorDto("error", "malformed-request");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(QuotaReachedException.class)
    public ResponseEntity<ErrorDto> handleQuotaReachedException(QuotaReachedException quotaReachedException) {
        ErrorDto errorDto = new ErrorDto("error", "quota-reached");
        return new ResponseEntity<>(errorDto, HttpStatus.TOO_MANY_REQUESTS);
    }

    @ExceptionHandler(UnsupportedCurrencyCodeException.class)
    public ResponseEntity<ErrorDto> handleUnsupportedCurrencyCodeException(UnsupportedCurrencyCodeException unsupportedCurrencyCodeException) {
        ErrorDto errorDto = new ErrorDto("error", "unsupported-code");
        return new ResponseEntity<>(errorDto, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleGenericException(Exception exception) {
        ErrorDto errorDto = new ErrorDto("error", "internal-server-error");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
