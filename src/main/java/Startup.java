import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 * Created by asari on 2015/05/04.
 */
@Singleton
@javax.ejb.Startup
public class Startup {
    @Inject
    private MessageRepository repository;

    @PostConstruct
    public void startup() {
        for (int i = 0; i < 10; i++) {
            Message message = new Message();
            message.setTitle("title #" + i);
            message.setAuthor("author #" + i);
            message.setContext("context #" + i);
            repository.save(message);
        }
    }
}
