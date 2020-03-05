package test.springframework.bookstestproject.repositories;

import test.springframework.bookstestproject.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
