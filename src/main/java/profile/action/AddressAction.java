package profile.action;

import profile.model.Address;
import profile.model.Profile;
import profile.model.ProfileHolder;

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

    @Override
    public Address getSelected() {
        Address address = profileHolder.getProfile().getAddress();
        if(address != null && address.getId() != null && !address.isFetched()) {
            address.setStreet("street #" + address.getId());
            address.setFetched(true);
            System.out.println("Address fetched!");
        }
        return address;
    }
}
