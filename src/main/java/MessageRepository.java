import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by asari on 2015/04/14.
 */
public class MessageRepository extends SimpleRepository<Message> {

    @PostConstruct
    public void init() {

    }

}
