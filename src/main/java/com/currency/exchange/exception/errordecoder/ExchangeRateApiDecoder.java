package com.currency.exchange.exception.errordecoder;

import com.currency.exchange.exception.customexceptions.*;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ExchangeRateApiDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 400 -> new UnsupportedCurrencyCodeException("Unsupported Currency code");
            case 401 -> new InvalidKeyException("Invalid API key");
            case 403 -> new InactiveAccountException("Inactive account");
            case 404 -> new MalformedRequestException("Malformed Request");
            case 429 -> new QuotaReachedException("Quota reached");
            default -> new Exception("Other error: " + response.status());
        };
    }
}





