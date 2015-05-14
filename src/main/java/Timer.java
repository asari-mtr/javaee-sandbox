import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by asari on 2015/05/15.
 */
@Named
@SessionScoped
public class Timer implements Serializable{
    public Date now() {
        return new Date();
    }
}
