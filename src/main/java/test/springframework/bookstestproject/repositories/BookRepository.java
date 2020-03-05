package test.springframework.bookstestproject.repositories;

import test.springframework.bookstestproject.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
