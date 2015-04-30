import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asari on 2015/04/14.
 */
public class MessageRepository {

    @PersistenceContext(name = "NewPersistenceUnit")
    private EntityManager entityManager;

    @PostConstruct
    public void init() {

    }

    @Transactional
    public Message save(Message message) {
        entityManager.persist(message);

        return message;
    }

    @Transactional
    public List<Message> findAll() {
        CriteriaQuery<Message> query = entityManager.getCriteriaBuilder().createQuery(Message.class);
        CriteriaQuery<Message> all = query.select(query.from(Message.class));
        return entityManager.createQuery(all).getResultList();
    }

    @Transactional
    public Message find(int id) {
        return entityManager.find(Message.class, id);
    }

}
