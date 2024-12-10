package com.currency.exchange.exception.errordecoder;

import com.currency.exchange.exception.customexceptions.*;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ExchangeRateApiDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 400 -> new MalformedRequestException("Malformed Request");
            case 401 -> new InvalidKeyException("Invalid API key");
            case 403 -> new InactiveAccountException("Inactive account");
            case 429 -> new QuotaReachedException("Quota reached");
            case 415 -> new UnsupportedCurrencyCodeException("Unsupported Currency code");
            default -> new Exception("Other error: " + response.status());
        };
    }
}





