package com.currency.exchange.client;

import com.currency.exchange.config.FeignConfigClient;
import com.currency.exchange.dto.exchangeRates.AllRatesResponseDto;
import com.currency.exchange.dto.exchangeRates.PairRatesResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "exchange-rate-api", url = "${exchange-rate-api.api.url}", configuration = FeignConfigClient.class)
public interface ExchangeRateApiClient {

    @GetMapping("/latest/{currencyType}")
    AllRatesResponseDto getExchangeRates(
            @PathVariable("currencyType") String currencyType);

    @GetMapping("/pair/{currency1}/{currency2}")
    PairRatesResponseDto getPairExchangeRates(@PathVariable("currency1") String currencyType1,
                                              @PathVariable("currency2") String currencyType2);
}

