package profile.model;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by asari on 2015/06/14.
 */
@ConversationScoped
public class ProfileHolder implements Serializable {
    @Inject
    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
