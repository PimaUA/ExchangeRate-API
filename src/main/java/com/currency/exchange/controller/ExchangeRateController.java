package com.currency.exchange.controller;

import com.currency.exchange.dto.AllRatesResponseDTO;
import com.currency.exchange.dto.PairRatesResposnseDTO;
import com.currency.exchange.service.ExchangeRateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ExchangeRateController {
    private ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/allExchangeRates/{currency}")
    public AllRatesResponseDTO getLatestExchangeRates(@PathVariable String currency) {
        return exchangeRateService.getExchangeRates(currency);
    }

    @GetMapping("/pairExchangeRates/{currency1}/{currency2}")
    public PairRatesResposnseDTO getPairExchangeRates(@PathVariable("currency1")String currency1,
                                                      @PathVariable("currency2")String currency2){
        return exchangeRateService.getPairExchangeRates(currency1,currency2);
    }
}
