package com.currency.exchange.exception.customexceptions;

public class InvalidKeyException extends RuntimeException{

    public InvalidKeyException(String message){
        super(message);
    }
}
