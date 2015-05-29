package repository;

import entity.Dictionary;
import entity.Personal;
import entity.Personal_;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
        query.select(root);
        return query.orderBy(builder.asc(root.get(Personal_.name)));
    }
}
