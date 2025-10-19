package io.github.sandes.domain.model;

public interface BookRepository {
    Book findById(Long id);
}
