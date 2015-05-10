import entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by asari on 2015/04/14.
 */
@Entity
public class Message extends AbstractEntity {
    @Column
    private String title;
    @Column
    private String context;
    @Column
    private String author;
    @Column
    private Date updateDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
