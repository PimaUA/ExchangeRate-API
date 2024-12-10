package com.currency.exchange.dto.exchangeRates;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class AllRatesResponseDto {
    public String result;
    @JsonProperty("time_last_update_utc")
    private String timeLastUpdateUtc;
    @JsonProperty("time_next_update_utc")
    private String timeNextUpdateUtc;
    @JsonProperty("base_code")
    private String baseCode;
    @JsonProperty("conversion_rates")
    private Map<String, Double> conversionRates;
}
