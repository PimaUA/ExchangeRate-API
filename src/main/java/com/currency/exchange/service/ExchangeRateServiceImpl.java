package com.currency.exchange.service;

import com.currency.exchange.client.ExchangeRateApiClient;
import com.currency.exchange.dto.exchangeRates.AllRatesResponseDto;
import com.currency.exchange.dto.exchangeRates.PairRatesResponseDto;
import com.currency.exchange.exception.customexceptions.UnsupportedCurrencyCodeException;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService{
    private ExchangeRateApiClient exchangeRateApiClient;

    public ExchangeRateServiceImpl(ExchangeRateApiClient exchangeRateApiClient) {
        this.exchangeRateApiClient = exchangeRateApiClient;
    }

    @Override
    public AllRatesResponseDto getExchangeRates(String currencyType){
        if(isValidCurrency(currencyType)){
            throw new UnsupportedCurrencyCodeException("Invalid currency");
        }
        return exchangeRateApiClient.getExchangeRates(currencyType);
    }

    @Override
    public PairRatesResponseDto getPairExchangeRates(String currency1, String currency2) {
        if(isValidCurrency(currency1) || isValidCurrency(currency2)){
            throw new UnsupportedCurrencyCodeException("Invalid currencies");
        }
        return exchangeRateApiClient.getPairExchangeRates(currency1,currency2);
    }

    private boolean isValidCurrency(String currency) {
        return currency == null || !currency.matches("[A-Z]{3}");
    }
}
