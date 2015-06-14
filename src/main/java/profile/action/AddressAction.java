package profile.action;

import profile.model.Address;
import profile.model.Profile;

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
    private Profile profile;

    @Inject
    private Conversation conversation;

    @Override
    public Address getSelected() {
        Address address = profile.getAddress();
        if(address != null && address.getId() != null && !address.isFetched()) {
            address.setStreet("street #" + address.getId());
            address.setFetched(true);
            System.out.println("Address fetched!");
        }
        return address;
    }
}
