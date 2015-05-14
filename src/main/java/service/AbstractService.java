package service;

import entity.AbstractEntity;
import repository.SmartRepository;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by asari on 2015/05/15.
 */
public abstract class AbstractService<E extends AbstractEntity> implements Service<E> {
    @Override
    @Transactional
    public Collection<E> findAll() {
        return getRepository().findAll();
    }
    @Override
    @Transactional
    public E save(E e){
        return getRepository().save(e);
    }
    @Override
    @Transactional
    public E find(int id) {
        return getRepository().find(id);
    }
}
