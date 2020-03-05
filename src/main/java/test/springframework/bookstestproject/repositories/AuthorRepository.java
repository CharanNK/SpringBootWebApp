package test.springframework.bookstestproject.repositories;

import test.springframework.bookstestproject.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
