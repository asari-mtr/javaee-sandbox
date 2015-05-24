package entity;

import javax.persistence.*;

/**
 * Created by asari on 2015/05/09.
 */
@MappedSuperclass
public class AbstractEntity {
    @Id
    @Column
    @GeneratedValue
    private Long id;
    @Version
    private int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
