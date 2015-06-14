package profile.model;

import java.io.Serializable;

/**
 * Created by asari on 2015/06/13.
 */
public class ViewModel implements Serializable {
    private Long id;
    private boolean fetched;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isFetched() {
        return fetched;
    }

    public void setFetched(boolean fetched) {
        this.fetched = fetched;
    }
}
