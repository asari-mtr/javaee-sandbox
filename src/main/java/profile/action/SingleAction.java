package profile.action;

import profile.model.ViewModel;

import java.io.Serializable;

/**
 * Created by asari on 2015/06/13.
 */
public interface SingleAction<E extends ViewModel> extends Serializable {
    E getSelected();
}
