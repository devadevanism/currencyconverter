package com.example.currencyconverter.controller;

import com.example.currencyconverter.model.ConversionRequest;
import com.example.currencyconverter.model.ConversionResponse;
import com.example.currencyconverter.model.ExchangeRatesResponse;
import com.example.currencyconverter.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private ExchangeRateService exchangeRateService;

   
    @GetMapping("/rates")
    public ExchangeRatesResponse getRates(@RequestParam(defaultValue = "USD") String base) {
        return exchangeRateService.getExchangeRates(base);
    }


    @PostMapping("/convert")
    public ConversionResponse convertCurrency(@RequestBody ConversionRequest request) {
        ExchangeRatesResponse ratesResponse = exchangeRateService.getExchangeRates(request.getFrom());
        double rate = ratesResponse.getRates().get(request.getTo());
        double convertedAmount = request.getAmount() * rate;

        ConversionResponse response = new ConversionResponse();
        response.setFrom(request.getFrom());
        response.setTo(request.getTo());
        response.setAmount(request.getAmount());
        response.setConvertedAmount(convertedAmount);

        return response;
    }
}