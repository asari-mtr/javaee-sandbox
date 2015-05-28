package action;

import entity.AbstractEntity;
import entity.Comic;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.function.Function;

/**
 * Created by asari on 2015/05/28.
 */
@Named
@RequestScoped
public class Sample2Action {
    private int id;

    public int getId() {
        System.out.println(this + "sample2Action.getId " + id);
        return id;
    }

    public void setId(int id) {
        System.out.println(this + "sample2Action.setId " + id);
        this.id = id;
    }

    public DeleteAction getDeleteAction () {
        return () -> {
            return "view2.xhtml";
        };
    }
}
