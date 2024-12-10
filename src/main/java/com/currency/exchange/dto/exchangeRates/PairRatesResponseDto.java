package com.currency.exchange.dto.exchangeRates;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PairRatesResponseDto {
    public String result;
    @JsonProperty("time_last_update_utc")
    public String timeLastUpdateUtc;
    @JsonProperty("time_next_update_utc")
    public String timeNextUpdateUtc;
    @JsonProperty("base_code")
    public String baseCode;
    @JsonProperty("target_code")
    public String targetCode;
    @JsonProperty("conversion_rate")
    public double conversionRate;
}
