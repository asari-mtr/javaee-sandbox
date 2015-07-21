package session;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by asari on 2015/06/30.
 */
@Dependent
@Named
public class Dog implements Serializable{
    private String name;

    @PostConstruct
    public void init(){
        name = "jack";
        System.out.println("Dog init");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
