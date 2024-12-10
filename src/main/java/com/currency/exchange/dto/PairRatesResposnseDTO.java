package com.currency.exchange.dto;

import java.util.Map;

public class PairRatesResposnseDTO {
    public String result;
    public String time_last_update_utc;
    public String time_next_update_utc;
    public String base_code;
    public String target_code;
    public double conversion_rate;
}
