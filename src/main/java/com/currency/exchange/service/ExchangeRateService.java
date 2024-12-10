package com.currency.exchange.service;

import com.currency.exchange.dto.exchangeRates.AllRatesResponseDto;
import com.currency.exchange.dto.exchangeRates.PairRatesResponseDto;

public interface ExchangeRateService {

    AllRatesResponseDto getExchangeRates(String currencyType);

    PairRatesResponseDto getPairExchangeRates(String currency1, String currency2);
}
