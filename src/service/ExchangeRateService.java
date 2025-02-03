package com.example.currencyconverter.service;

import com.example.currencyconverter.model.ExchangeRatesResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeRateService {
    private static final String API_URL = "https://api.exchangeratesapi.io/latest?base=";

    public ExchangeRatesResponse getExchangeRates(String baseCurrency) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + baseCurrency;
        return restTemplate.getForObject(url, ExchangeRatesResponse.class);
    }
}