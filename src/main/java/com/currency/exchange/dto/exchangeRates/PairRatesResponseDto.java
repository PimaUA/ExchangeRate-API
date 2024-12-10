package com.currency.exchange.dto.exchangeRates;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PairRatesResponseDto {
    private String result;
    @JsonProperty("time_last_update_utc")
    private String timeLastUpdateUtc;
    @JsonProperty("time_next_update_utc")
    private String timeNextUpdateUtc;
    @JsonProperty("base_code")
    private String baseCode;
    @JsonProperty("target_code")
    private String targetCode;
    @JsonProperty("conversion_rate")
    private double conversionRate;
}
