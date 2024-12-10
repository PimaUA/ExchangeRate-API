package com.currency.exchange.service;

import com.currency.exchange.client.ExchangeRateApiClient;
import com.currency.exchange.dto.AllRatesResponseDTO;
import com.currency.exchange.dto.PairRatesResposnseDTO;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService{
    private ExchangeRateApiClient exchangeRateApiClient;

    public ExchangeRateServiceImpl(ExchangeRateApiClient exchangeRateApiClient) {
        this.exchangeRateApiClient = exchangeRateApiClient;
    }

    @Override
    public AllRatesResponseDTO getExchangeRates(String currencyType){
        return exchangeRateApiClient.getExchangeRates(currencyType);
    }

    @Override
    public PairRatesResposnseDTO getPairExchangeRates(String currency1, String currency2) {
        return exchangeRateApiClient.getPairExchangeRates(currency1,currency2);
    }
}
