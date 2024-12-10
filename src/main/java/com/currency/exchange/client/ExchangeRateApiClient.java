package com.currency.exchange.client;

import com.currency.exchange.config.FeignConfigClient;
import com.currency.exchange.dto.AllRatesResponseDTO;
import com.currency.exchange.dto.PairRatesResposnseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "exchangeRate-API", url = "${exchangeRate-API.api.url}", configuration = FeignConfigClient.class)
public interface ExchangeRateApiClient {

    @GetMapping("/latest/{currencyType}")
    AllRatesResponseDTO getExchangeRates(
            @PathVariable("currencyType") String currencyType);

    @GetMapping("/pair/{currency1}/{currency2}")
    PairRatesResposnseDTO getPairExchangeRates(@PathVariable("currency1") String currencyType1,
                                               @PathVariable("currency2") String currencyType2);
}

