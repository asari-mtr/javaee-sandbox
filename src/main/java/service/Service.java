package service;

import entity.AbstractEntity;
import repository.SmartRepository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by asari on 2015/05/15.
 */
public interface Service<E extends AbstractEntity> extends Serializable {
    SmartRepository<E> getRepository();

    @Transactional
    Collection<E> findAll();

    @Transactional
    E save(E e);

    @Transactional
    E find(int id);
}
