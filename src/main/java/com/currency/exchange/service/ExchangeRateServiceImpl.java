package com.currency.exchange.service;

import com.currency.exchange.client.ExchangeRateApiClient;
import com.currency.exchange.dto.exchangeRates.AllRatesResponseDto;
import com.currency.exchange.dto.exchangeRates.PairRatesResponseDto;
import com.currency.exchange.service.validation.CurrencyValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private ExchangeRateApiClient exchangeRateApiClient;
    private CurrencyValidationService currencyValidationService;
    private static final Logger logger = LoggerFactory.getLogger(ExchangeRateServiceImpl.class);

    public ExchangeRateServiceImpl(ExchangeRateApiClient exchangeRateApiClient,
                                   CurrencyValidationService currencyValidationService) {
        this.exchangeRateApiClient = exchangeRateApiClient;
        this.currencyValidationService = currencyValidationService;
    }

    @Override
    public AllRatesResponseDto getExchangeRates(String currencyType) {
        logger.info("Fetching exchange rates for currency: {}", currencyType);
        currencyValidationService.validateCurrencies(currencyType);
        return exchangeRateApiClient.getExchangeRates(currencyType);
    }

    @Override
    public PairRatesResponseDto getPairExchangeRates(String currencyType1, String currencyType2) {
        logger.info("Fetching pair exchange rates for currencies: {} and {}", currencyType1, currencyType2);
        currencyValidationService.validateCurrencies(currencyType1, currencyType2);
        return exchangeRateApiClient.getPairExchangeRates(currencyType1, currencyType2);
    }
}
