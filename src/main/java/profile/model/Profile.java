package profile.model;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;

/**
 * Created by asari on 2015/06/13.
 */
@ConversationScoped
public class Profile extends ViewModel {
    private String name;
    private Address address;
    private Job job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
