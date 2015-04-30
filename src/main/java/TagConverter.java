import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 * Created by asari on 2015/04/30.
 */
@FacesConverter(value = "tagConverter", forClass = Tag.class)
public class TagConverter implements Converter{
    @Inject
    private TagRepository repository;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return repository.find(Integer.valueOf(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return String.valueOf(((Tag) o).getId());
    }
}
