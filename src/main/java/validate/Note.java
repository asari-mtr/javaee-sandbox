package validate;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by asari on 2015/07/22.
 */
@Named
@RequestScoped
public class Note {
    @NotNull
    private String title;
    @Size(min = 5)
    private String body;

    public String save() {
        // nop
        return null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
