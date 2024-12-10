package com.currency.exchange.controller;

import com.currency.exchange.dto.exchangeRates.AllRatesResponseDto;
import com.currency.exchange.dto.exchangeRates.PairRatesResponseDto;
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
    public AllRatesResponseDto getLatestExchangeRates(@PathVariable String currency) {
        return exchangeRateService.getExchangeRates(currency);
    }

    @GetMapping("/pairExchangeRates/{currency1}/{currency2}")
    public PairRatesResponseDto getPairExchangeRates(@PathVariable("currency1")String currency1,
                                                     @PathVariable("currency2")String currency2){
        return exchangeRateService.getPairExchangeRates(currency1,currency2);
    }
}
