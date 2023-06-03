package com.springframework.spring6webapp.bootstrap;

import com.springframework.spring6webapp.domain.Author;
import com.springframework.spring6webapp.domain.Book;
import com.springframework.spring6webapp.domain.Publisher;
import com.springframework.spring6webapp.repositories.AuthorRepository;
import com.springframework.spring6webapp.repositories.BookRepository;
import com.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author ben = new Author();
        ben.setFirstName("Bernard");
        ben.setLastName("Omwami");


        Book book1 = new Book();
        book1.setTitle("Kingdom Come");
        book1.setIsbn("5464387837");


        Author benSaved = authorRepository.save(ben);
        Book book1Saved = bookRepository.save(book1);

        Author jerry = new Author();
        jerry.setFirstName("Jerry");
        jerry.setLastName("Wayan");


        Book book2 = new Book();
        book2.setTitle("Kingdom Come");
        book2.setIsbn("5464387837");


        Author jerrySaved = authorRepository.save(jerry);
        Book book2Saved = bookRepository.save(book2);

        //association
        benSaved.getBooks().add(book1Saved);
        jerrySaved.getBooks().add(book2Saved);
book1Saved.getAuthors().add(benSaved);
book2Saved.getAuthors().add(jerrySaved);


        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("Tom Mboya");
        publisher.setCity("Nairobi");
        publisher.setState("State House");
        publisher.setZipcode("00200");
        Publisher savePublisher =  publisherRepository.save(publisher);

        book1Saved.setPublisher(savePublisher);
        book2Saved.setPublisher(savePublisher);


        authorRepository.save(benSaved);
        authorRepository.save(jerrySaved);
        bookRepository.save(book1Saved);
        bookRepository.save(book2Saved);

        System.out.println("BootStrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}
