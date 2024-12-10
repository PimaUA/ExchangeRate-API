package com.currency.exchange.exception.customexceptions;

public class MalformedRequestException extends RuntimeException{

    public MalformedRequestException(String message){
        super(message);
    }
}
