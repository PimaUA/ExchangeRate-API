package com.currency.exchange.exception.customexceptions;

public class UnsupportedCurrencyCodeException extends RuntimeException{

    public UnsupportedCurrencyCodeException(String message){
        super(message);
    }
}
