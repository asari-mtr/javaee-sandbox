package decorate;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 * Created by asari on 2015/07/23.
 */
@Priority(0)
@Decorator
@Dependent
public class EditDecorator implements Editable {
    @Delegate
    @Inject
    private  Editable editable;

    @Override
    public String save() {
        return "[" + editable.save() + "]";
    }

    @Override
    public String delete() {
        return "[" + editable.delete() + "]";
    }
}
