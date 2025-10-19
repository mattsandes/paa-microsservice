package io.github.sandes.addapters.outbound.repositories;

import io.github.sandes.addapters.entities.JpaExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaExchangeRepository extends JpaRepository<JpaExchangeEntity, Long> {

    JpaExchangeEntity findByFromAndTo(String from, String to);
}
