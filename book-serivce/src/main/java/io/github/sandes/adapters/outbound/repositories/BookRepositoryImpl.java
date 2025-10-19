package io.github.sandes.adapters.outbound.repositories;

import io.github.sandes.adapters.entities.JpaBookEntity;
import io.github.sandes.domain.model.Book;
import io.github.sandes.domain.model.BookRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final JpaBookRepository bookRepository;

    public BookRepositoryImpl(JpaBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findById(Long id) {
        JpaBookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar um livro com esse id"));

        return new Book(
                bookEntity.getId(),
                bookEntity.getTitle(),
                bookEntity.getAuthor(),
                bookEntity.getLaunchDate(),
                bookEntity.getPrice(),
                bookEntity.getCurrency()
        );
    }
}
