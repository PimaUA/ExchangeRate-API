package com.currency.exchange.dto.exchangeRates;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class AllRatesResponseDto {
    public String result;
    @JsonProperty("time_last_update_utc")
    public String timeLastUpdateUtc;
    @JsonProperty("time_next_update_utc")
    public String timeNextUpdateUtc;
    @JsonProperty("base_code")
    public String baseCode;
    @JsonProperty("conversion_rates")
    public Map<String, Double> conversionRates;
}
