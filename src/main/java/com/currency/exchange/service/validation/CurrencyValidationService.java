package com.currency.exchange.service.validation;

import com.currency.exchange.exception.customexceptions.UnsupportedCurrencyCodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CurrencyValidationService {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyValidationService.class);

    public void validateCurrencies(String... currencies) {
        for (String currency : currencies) {
            if (isInvalidCurrency(currency)) {
                logger.error("Invalid currency type provided: {}", currency);
                throw new UnsupportedCurrencyCodeException("Invalid currency: " + currency);
            }
        }
    }

    public boolean isInvalidCurrency(String currency) {
        return currency == null || !currency.matches("[A-Z]{3}");
    }
}
