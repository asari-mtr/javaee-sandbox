package repository;

import entity.AbstractEntity;
import entity.Comic;

import javax.ejb.Stateless;

/**
 * Created by asari on 2015/05/15.
 */
@Stateless
public class ComicRepository extends SmartRepository<Comic> {
}
