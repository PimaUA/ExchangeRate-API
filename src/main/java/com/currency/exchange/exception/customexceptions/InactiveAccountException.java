package com.currency.exchange.exception.customexceptions;

public class InactiveAccountException extends RuntimeException{

    public InactiveAccountException(String message){
        super(message);
    }
}
