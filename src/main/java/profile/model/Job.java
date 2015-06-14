package profile.model;

import javax.enterprise.context.Dependent;

/**
 * Created by asari on 2015/06/13.
 */
@Dependent
public class Job extends ViewModel {
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
