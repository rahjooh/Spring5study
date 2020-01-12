package hadi.springframework.spring5webapp.bootstrap;

import hadi.springframework.spring5webapp.model.Author;
import hadi.springframework.spring5webapp.model.Book;
import hadi.springframework.spring5webapp.repositories.AuthorRepository;
import hadi.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //hadi
        Author hadi = new Author("Hadi","Rahjou");
        Book hadibook = new Book("hadi's life","1234","computer publisher");
        hadi.getBooks().add(hadibook);
        hadibook.getAuthors().add(hadi);

        authorRepository.save(hadi);
        bookRepository.save(hadibook);

        //shima
        Author shima = new Author("Shima","Esmaeli");
        Book shimabook = new Book("How to account with shima ","2233444","Stocks");
        shima.getBooks().add(shimabook);

        authorRepository.save(shima);
        bookRepository.save(shimabook);
    }
}
