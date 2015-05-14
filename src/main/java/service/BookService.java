package service;

import entity.Book;
import repository.BookRepository;
import repository.SmartRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by asari on 2015/05/15.
 */
@Stateless
public class BookService extends AbstractService<Book> {

    @Inject
    private BookRepository repository;

    @Override
    public SmartRepository<Book> getRepository() {
        return repository;
    }
}
