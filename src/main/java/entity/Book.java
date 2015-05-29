package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by asari on 2015/05/15.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Book extends AbstractEntity{
    private String title;
    private String author;
//    @Temporal(TemporalType.DATE)
//    private Date publishDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public Date getPublishDate() {
//        return publishDate;
//    }
//
//    public void setPublishDate(Date publishDate) {
//        this.publishDate = publishDate;
//    }

    @Override
    public String toString() {
        return getId() + ":" + title;
    }
}
