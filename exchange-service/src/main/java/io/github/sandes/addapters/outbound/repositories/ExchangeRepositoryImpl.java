package io.github.sandes.addapters.outbound.repositories;

import io.github.sandes.addapters.entities.JpaExchangeEntity;
import io.github.sandes.domain.model.Exchange;
import io.github.sandes.domain.model.ExchangeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangeRepositoryImpl implements ExchangeRepository {

    private final JpaExchangeRepository exchangeRepository;

    public ExchangeRepositoryImpl(JpaExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @Override
    public Exchange findByFromAndTo(String from, String to) {
        JpaExchangeEntity exchangeEntity = exchangeRepository.findByFromAndTo(from, to);

        return new Exchange(
                exchangeEntity.getId(),
                exchangeEntity.getFrom(),
                exchangeEntity.getTo(),
                exchangeEntity.getConversionFactor(),
                exchangeEntity.getConvertedValue()
        );
    }
}
