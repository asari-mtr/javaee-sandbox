package action;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created by asari on 2015/05/28.
 */
@Named
@RequestScoped
public class Sample1Action {
    private int id;

    public int getId() {
        System.out.println(this + "sample1Action.getId " + id);
        return id;
    }

    public void setId(int id) {
        System.out.println(this + "sample1Action.setId " + id);
        this.id = id;
    }
}
