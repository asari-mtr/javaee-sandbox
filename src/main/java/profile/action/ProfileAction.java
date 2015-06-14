package profile.action;

import profile.model.Address;
import profile.model.Job;
import profile.model.Profile;
import profile.model.ProfileHolder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by asari on 2015/06/13.
 */
@Named
@ConversationScoped
public class ProfileAction implements SingleAction {
    private Long id;

    @Inject
    private Conversation conversation;
    @Inject
    private ProfileHolder profileHolder;
    public void beginConversation () {
        if(conversation.isTransient()) {
            conversation.begin();
            conversation.setTimeout(100000);
            System.out.println("会話開始");
        }
    }
    public void endConversation () {
        if(!conversation.isTransient()){
            conversation.end();
            System.out.println("会話終了");
        }
    }
    public Profile getSelected() {
        Profile profile = profileHolder.getProfile();
        if (profile.getId() == null || profile.getId() != id || !profile.isFetched()) {

            // 本当はロードされるイメージ
            profile.setId(id);
            profile.setName("name #" + id);
            Address address = new Address();
            address.setId(id * 13);
            profile.setAddress(address);
            Job job = new Job();
            job.setId(id * 17);
            profile.setJob(job);
            profile.setFetched(true);
            System.out.println("Profile fetched!");
        }
        profileHolder.setProfile(profile);
        return profileHolder.getProfile();
    }
    public String getCid() {
        return conversation.getId();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profileHolder.getProfile();
    }

    public void setProfile(Profile profile) {
        profileHolder.setProfile(profile);
    }
}
