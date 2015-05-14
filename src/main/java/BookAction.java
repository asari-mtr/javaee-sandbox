import service.*;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by asari on 2015/05/15.
 */
@Named
@SessionScoped
public class BookAction implements Serializable {
    private Service service;

    public Service getService() {
        if(service == null) {
            service = bookService;
        }
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Inject
    private BookService bookService;
    @Inject
    private ComicService comicService;
    @Inject
    private DictionaryService dictionaryService;
    @Inject
    private MagazineService magazineService;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        if("book".equals(type)){
            setService(bookService);
        }
        if("comic".equals(type)){
            setService(comicService);
        }
        if("dictionary".equals(type)){
            setService(dictionaryService);
        }
        if("magazine".equals(type)){
            setService(magazineService);
        }
    }

    public Collection findAll() {
        return getService().findAll();
    }
}
