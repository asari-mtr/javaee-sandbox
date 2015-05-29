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

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String deleteSample2() {
        System.out.println("Delete " + name);
        return "view2.xhtml";
    }

    public DeleteAction getDeleteAction() {
        return this::deleteSample2;
    }
}
