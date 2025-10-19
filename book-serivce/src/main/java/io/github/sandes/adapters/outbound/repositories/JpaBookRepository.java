package io.github.sandes.adapters.outbound.repositories;

import io.github.sandes.adapters.entities.JpaBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookRepository extends JpaRepository<JpaBookEntity, Long> {
}
