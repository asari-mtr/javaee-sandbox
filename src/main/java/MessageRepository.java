import repository.SimpleRepository;
import repository.SmartRepository;

import javax.annotation.PostConstruct;

/**
 * Created by asari on 2015/04/14.
 */
public class MessageRepository extends SmartRepository<Message> {

    @PostConstruct
    public void init() {

    }

}
