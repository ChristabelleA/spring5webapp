package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Repository.AuthorRepository;
import guru.springframework.spring5webapp.Repository.BookRepository;
import guru.springframework.spring5webapp.Repository.PublisherRepository;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class bootstrap implements CommandLineRunner {

    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;
    private final PublisherRepository publisherRepo;

    public bootstrap(BookRepository bookRepo, AuthorRepository authorRepo, PublisherRepository publisherRepository) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.publisherRepo = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher pub1 = new Publisher();
        pub1.setName("alpha");
        pub1.setCity("London");
        pub1.setRoadName("ella");
        publisherRepo.save(pub1);

        Book book1 = new Book("Alphabet", "1234556678");
        Author author1 = new Author("Ben", "Franklin");
        Book book2 = new Book("ABC", "2324423423e");

        author1.getBook().add(book1);
        book1.getAuthor().add(author1);
        author1.getBook().add(book2);
        book2.getAuthor().add(author1);

        authorRepo.save(author1);
        bookRepo.save(book2);
        bookRepo.save(book1);

        book1.setPublisher(pub1);
        pub1.getBooks().add(book1);

        System.out.println("number of books " + bookRepo.count());
        System.out.println("number of author " + authorRepo.count());
    }
}
