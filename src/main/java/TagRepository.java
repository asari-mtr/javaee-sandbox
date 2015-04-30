import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by asari on 2015/04/14.
 */
public class TagRepository {

    @PersistenceContext(name = "NewPersistenceUnit")
    private EntityManager entityManager;

    @PostConstruct
    public void init() {

    }

    @Transactional
    public Tag save(Tag tag) {
        entityManager.persist(tag);
        return tag;
    }

    @Transactional
    public List<Tag> findAll() {
        CriteriaQuery<Tag> query = entityManager.getCriteriaBuilder().createQuery(Tag.class);
        CriteriaQuery<Tag> all = query.select(query.from(Tag.class));
        return entityManager.createQuery(all).getResultList();
    }

    @Transactional
    public Tag find(int id) {
        return entityManager.find(Tag.class, id);
    }
}
