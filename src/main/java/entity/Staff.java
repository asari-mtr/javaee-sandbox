package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by asari on 2015/05/09.
 */
@Entity
public class Staff extends AbstractEntity {
    /**
     * 名前
     */
    @Column
    private String name;

    /**
     * 役職
     */
    @Column
    private String position;

    @OneToOne (cascade = CascadeType.ALL)
    private Contact contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
