package profile.action;

import profile.model.Address;
import profile.model.Job;
import profile.model.Profile;
import profile.model.ProfileHolder;
import profile.service.ProfileService;

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
    private ProfileService service;

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
        if (id == null) {
            id = Long.valueOf((int)(Math.random() * 1000));
        }
        if (profile.getId() == null || profile.getId() != id || !profile.isFetched()) {
            profile = service.find(id);
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
}
