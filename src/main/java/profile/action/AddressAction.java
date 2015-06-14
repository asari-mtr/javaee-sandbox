package profile.action;

import profile.model.Address;
import profile.model.Profile;
import profile.model.ProfileHolder;
import profile.service.ProfileService;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by asari on 2015/06/13.
 */
@Named
@ConversationScoped
public class AddressAction implements SingleAction<Address> {
    @Inject
    private ProfileHolder profileHolder;
    @Inject
    private ProfileService service;

    @Override
    public Address getSelected() {
        Address address = profileHolder.getProfile().getAddress();
        if(address != null && address.getId() != null && !address.isFetched()) {
            Address newAddress = service.findAddress(profileHolder.getProfile().getId(), address.getId());
            newAddress.setFetched(true);
            profileHolder.getProfile().setAddress(newAddress);
            System.out.println("Address fetched!");
        }
        return profileHolder.getProfile().getAddress();
    }
}
