package repository;

import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.Collection;

/**
 * Created by asari on 2015/05/15.
 */
public class PersonalRepository extends SmartRepository<Personal> {
    public Collection<Personal> findMany(String keyword) {
        EntityManager entityManager = getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Personal> query = builder.createQuery(Personal.class);
        Root<Personal> root = query.from(Personal.class);

        CriteriaQuery<Personal> findQuery = generateQuery(builder, query, root, keyword);
        TypedQuery<Personal> typedQuery = getEntityManager().createQuery(findQuery
        );
        return typedQuery.getResultList();
    }

    private CriteriaQuery<Personal> generateQuery(CriteriaBuilder builder, CriteriaQuery<Personal> query, Root<Personal> root, String keyword) {
//        query.select(root);
        Join<Personal, Book> book = root.join(Personal_.book);
        query.where(builder.equal(book.get(Book_.title), keyword));
        return query.orderBy(builder.asc(root.get(Personal_.name)));
    }

    public Collection<Personal> findComic() {
        EntityManager entityManager = getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Personal> query = builder.createQuery(Personal.class);
        Root<Personal> root = query.from(Personal.class);

        CriteriaQuery<Personal> findQuery = generateQueryByComic(builder, query, root);
        TypedQuery<Personal> typedQuery = getEntityManager().createQuery(findQuery
        );
        return typedQuery.getResultList();
    }

    private CriteriaQuery<Personal> generateQueryByComic(CriteriaBuilder builder, CriteriaQuery<Personal> query, Root<Personal> root) {
        Join<Personal, Book> book = root.join(Personal_.book);
        query.where(builder.treat(book, Dictionary.class).isNotNull());
        return query.orderBy(builder.asc(root.get(Personal_.name)));
    }
}
