package test.springframework.bookstestproject.bootstrap;

import test.springframework.bookstestproject.domain.Author;
import test.springframework.bookstestproject.domain.Book;
import test.springframework.bookstestproject.domain.Publisher;
import test.springframework.bookstestproject.repositories.AuthorRepository;
import test.springframework.bookstestproject.repositories.BookRepository;
import test.springframework.bookstestproject.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book book1 = new Book("Intro to Spring Boot","123123");

        Publisher ajayPublisher = new Publisher("Ajay","Albert Street","Bangalore","Karnataka","560065");
        publisherRepository.save(ajayPublisher);

        eric.getBookSet().add(book1);
        book1.getAuthorSet().add(eric);

        book1.setPublisher(ajayPublisher);
        ajayPublisher.getBookSet().add(book1);

        authorRepository.save(eric);
        bookRepository.save(book1);
        publisherRepository.save(ajayPublisher);

        Author godz = new Author("Godz","Kumar");
        Book book2 = new Book("How to be like Godz","445645");

        godz.getBookSet().add(book2);
        book2.getAuthorSet().add(godz);

        book2.setPublisher(ajayPublisher);
        ajayPublisher.getBookSet().add(book2);

        authorRepository.save(godz);
        bookRepository.save(book2);
        publisherRepository.save(ajayPublisher);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books :"+bookRepository.count());
        System.out.println("Number of publishers :"+publisherRepository.count());
        System.out.println("Number of books with publisher : "+ajayPublisher.getBookSet().size());
    }
}
