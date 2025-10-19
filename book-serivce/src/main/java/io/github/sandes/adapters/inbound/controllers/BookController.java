package io.github.sandes.adapters.inbound.controllers;

import io.github.sandes.adapters.inbound.controllers.DTOs.Exchange;
import io.github.sandes.domain.model.Book;
import io.github.sandes.domain.model.BookRepository;
import io.github.sandes.infrastructure.proxy.ExchangeProxy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class BookController {

    private final ExchangeProxy exchangeProxy;
    private final BookRepository bookRepository;

    public BookController(ExchangeProxy exchangeProxy, BookRepository bookRepository) {
        this.exchangeProxy = exchangeProxy;
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBooks(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency) {

        var foundBook = bookRepository.findById(id);

        Exchange exchange = exchangeProxy.getExchange(
                foundBook.getPrice(),
                "USD",
                currency
        );

        foundBook.setCurrency(currency);
        foundBook.setPrice(exchange.getConvertedValue());

        return foundBook;
    }
}
