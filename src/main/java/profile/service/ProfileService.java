package profile.service;

import profile.model.Address;
import profile.model.Job;
import profile.model.Profile;

import javax.ejb.Stateless;
import java.io.Serializable;

/**
 * Created by asari on 2015/06/14.
 */
@Stateless
public class ProfileService implements Serializable {
    public Profile find(Long id) {
        Profile profile = new Profile();
        profile.setId(id);
        profile.setName("name #" + id);
        Address address = new Address();
        address.setId(id * 13);
        profile.setAddress(address);
        Job job = new Job();
        job.setId(id * 17);
        profile.setJob(job);
        return profile;
    }

    public Job findJob(Long profileId, Long jobId) {
        Job job = new Job();
        job.setId(jobId);
        job.setPosition("Position#" + jobId);
        return job;
    }

    public Address findAddress(Long profileId, Long addressId) {
        Address address = new Address();
        address.setId(addressId);
        address.setStreet("street #" + address.getId());
        return address;
    }
}
