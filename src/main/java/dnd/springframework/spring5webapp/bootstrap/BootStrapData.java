package dnd.springframework.spring5webapp.bootstrap;

import dnd.springframework.spring5webapp.domain.Author;
import dnd.springframework.spring5webapp.domain.Book;
import dnd.springframework.spring5webapp.repositories.AuthorRepository;
import dnd.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author( "Eric", "Evans" );
        Book book = new Book( "Domain Driven Design", "12222" );
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        Author rod = new Author( "Rod", "Johnson" );
        Book noEJB = new Book( "J2EE Dev without EJB", "223211" );

        rod.getBooks().add( noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        System.out.println( "Started in Bootstrap" );
        System.out.println( "Number of Books: " + bookRepository.count() );

    }

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

}
