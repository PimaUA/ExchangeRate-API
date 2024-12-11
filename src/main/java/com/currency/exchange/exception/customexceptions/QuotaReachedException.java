package com.currency.exchange.exception.customexceptions;

public class QuotaReachedException extends RuntimeException {

    public QuotaReachedException(String message) {
        super(message);
    }
}
