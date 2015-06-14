package profile.action;

import profile.model.Job;
import profile.model.Profile;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by asari on 2015/06/13.
 */
@Named
@ConversationScoped
public class JobAction implements SingleAction<Job> {
    @Inject
    private Profile profile;
    @Inject
    private Conversation conversation;

    @Override
    public Job getSelected() {
        Job job = profile.getJob();
        if(job != null && job.getId() != null && !job.isFetched()) {
            job.setPosition("position #" + job.getId());
            job.setFetched(true);
            System.out.println("Job fetched!");
        }
        return job;
    }
}
