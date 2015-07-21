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
public class DogAction2 implements Serializable{
    @Inject
    @Named("newDog")
    private Dog dog;
    @PostConstruct
    public void init () {
        dog.setName("taro");
    }
    public String getName(){
        return dog.getName();
    }
}
