package com.example.currencyconverter.service;

import com.example.currencyconverter.model.ExchangeRatesResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ExchangeRateServiceTest {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Test
    public void testGetExchangeRates() {
        ExchangeRatesResponse response = exchangeRateService.getExchangeRates("USD");
        assertNotNull(response);
        assertNotNull(response.getRates());
    }
}