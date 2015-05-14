package service;

import entity.Comic;
import entity.Magazine;
import repository.MagazineRepository;
import repository.SmartRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by asari on 2015/05/15.
 */
@Stateless
public class MagazineService extends AbstractService<Magazine> {

    @Inject
    private MagazineRepository repository;

    @Override
    public SmartRepository<Magazine> getRepository() {
        return repository;
    }
}
