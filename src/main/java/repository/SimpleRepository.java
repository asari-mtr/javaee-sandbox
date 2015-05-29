package repository;

import entity.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by asari on 2015/05/09.
 */
public class SimpleRepository<E extends AbstractEntity> extends AbstractRepository<E> {
    private Class<E> clazz;
    @PersistenceContext(name = "NewPersistenceUnit")
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public SimpleRepository() {
        // TODO きれいにしたい
        if(this.getClass().getGenericSuperclass().getTypeName().contains("SmartRepository")){
            Type type = this.getClass().getGenericSuperclass();
            clazz = (Class<E>) ((ParameterizedType) type).getActualTypeArguments()[0];
        }else {
            Type type = this.getClass().getSuperclass().getGenericSuperclass();
            clazz = (Class<E>) ((ParameterizedType) type).getActualTypeArguments()[0];

        }
    }

    @Transactional
    public E save(E e) {
        entityManager.persist(e);

        return e;
    }

    @Transactional
    public List<E> findAll() {
        CriteriaQuery<E> query = entityManager.getCriteriaBuilder().createQuery(clazz);
        CriteriaQuery<E> all = query.select(query.from(clazz));
        return entityManager.createQuery(all).getResultList();
    }

    @Transactional
    public E find(int id) {
        return entityManager.find(clazz, id);
    }
}
