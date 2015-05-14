package service;

import entity.Book;
import entity.Comic;
import repository.ComicRepository;
import repository.SmartRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by asari on 2015/05/15.
 */
@Stateless
public class ComicService extends AbstractService<Comic> {

    @Inject
    private ComicRepository repository;

    @Override
    public SmartRepository<Comic> getRepository() {
        return repository;
    }
}
