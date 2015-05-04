import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 * Created by asari on 2015/05/04.
 */
@Singleton
@javax.ejb.Startup
public class Startup {
    @PostConstruct
    public void init() {
        System.out.println("Hello Startup !!!!!");
    }
}
