package session;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by asari on 2015/06/30.
 */
@SessionScoped
@Named
public class DogProducer implements Serializable{
    @Produces
    @Named("newDog")
    public Dog getDog() {
        return new Dog();
    }

//    public void dispose(@Disposes Dog dog) {
//        System.out.println("Dispose " + dog.getName());
//    }

}
