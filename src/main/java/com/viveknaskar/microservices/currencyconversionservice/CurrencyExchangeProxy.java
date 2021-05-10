package com.viveknaskar.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * FeignClient annotation is used to consume REST API endpoint.
 * Here name is the application name to be consumed and
 * url is the rest endpoint
 * **************************************************
 * @FeignClient(name = "currency-exchange", url = "localhost:8000")
 */

/**
 * Just adding the application name to be consumed is enough in the FeignClient
 * as the multiple instances of the consumed rest api will be load balanced
 * by the eureka server
 */
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to);

}
