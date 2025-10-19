package io.github.sandes.domain.model;

public interface ExchangeRepository {
    Exchange findByFromAndTo(String from, String to);
}