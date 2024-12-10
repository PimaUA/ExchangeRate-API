package com.currency.exchange.dto;

import java.util.Map;

public class AllRatesResponseDTO {
    public String result;
    public String time_last_update_utc;
    public String time_next_update_utc;
    public String base_code;
    public Map<String, Double> conversion_rates;
}
