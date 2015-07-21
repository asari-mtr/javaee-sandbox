package session;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by asari on 2015/06/30.
 */
@RequestScoped
@Named
public class DogAction1 implements Serializable{
    @Inject
    @Named(value = "newDog")
    private Dog dog;
    @PostConstruct
    public void init () {
        dog.setName("pochi");
    }
    public String getName(){
        return dog.getName();
    }
}
