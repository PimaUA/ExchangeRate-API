package com.currency.exchange.service;

import com.currency.exchange.dto.AllRatesResponseDTO;
import com.currency.exchange.dto.PairRatesResposnseDTO;

public interface ExchangeRateService {

    AllRatesResponseDTO getExchangeRates(String currencyType);

    PairRatesResposnseDTO getPairExchangeRates(String currency1,String currency2);
}
