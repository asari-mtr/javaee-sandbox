package decorate;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 * Created by asari on 2015/07/23.
 */
@Named
@ConversationScoped
public class ExampleEditor implements Editable {
    @Override
    public String save() {
        return "Example save!";
    }

    @Override
    public String delete() {
        return "Example delete!";
    }
}
