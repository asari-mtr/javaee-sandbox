package decorate;

import java.io.Serializable;

/**
 * Created by asari on 2015/07/23.
 */
public interface  Editable extends Serializable {
    public String save();
    public String delete();
}
