package profile.model;

import javax.enterprise.context.Dependent;

/**
 * Created by asari on 2015/06/13.
 */
@Dependent
public class Address extends ViewModel {
    private String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
