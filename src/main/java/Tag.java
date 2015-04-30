import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by asari on 2015/04/14.
 */
@Entity
public class Tag {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private Date updateDate;

    public Tag () {

    }
    public  Tag (String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object obj) {
        Tag target = (Tag) obj;

        return target.getId() == this.getId();
    }
}
