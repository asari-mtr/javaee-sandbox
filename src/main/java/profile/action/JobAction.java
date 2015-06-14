package profile.action;

import profile.model.Job;
import profile.model.Profile;
import profile.model.ProfileHolder;
import profile.service.ProfileService;

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
    private ProfileHolder profileHolder;
    @Inject
    private ProfileService service;

    @Override
    public Job getSelected() {
        Job job = profileHolder.getProfile().getJob();
        if(job != null && job.getId() != null && !job.isFetched()) {
            Job newJob = service.findJob(profileHolder.getProfile().getId(), job.getId());
            newJob.setFetched(true);
            profileHolder.getProfile().setJob(newJob);
            System.out.println("Job fetched!");
        }
        return profileHolder.getProfile().getJob();
    }
}
