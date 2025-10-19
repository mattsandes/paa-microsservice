package io.github.sandes.addapters.inbout.controllers;

import io.github.sandes.domain.model.Exchange;
import io.github.sandes.domain.model.ExchangeRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("exchange-service")
public class ExchangeController {

    private final ExchangeRepository exchangeRepository;

    public ExchangeController(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @GetMapping(value = "/{amount}/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Exchange getExchange(
            @PathVariable("amount") BigDecimal amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to) {

        var exchange = exchangeRepository.findByFromAndTo(from, to);

        BigDecimal conversionFactor = exchange.getConversionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(amount);

        exchange.setConvertedValue(convertedValue);

        return exchange;
    }
}
