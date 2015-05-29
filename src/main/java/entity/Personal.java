package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by asari on 2015/05/30.
 */
@Entity
public class Personal extends AbstractEntity {
    @Column
    private String name;
    @OneToOne
    @JoinColumn(name = "hoge_id")
    private Book book;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
