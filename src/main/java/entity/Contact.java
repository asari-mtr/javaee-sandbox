package entity;

import javax.persistence.*;

/**
 * Created by asari on 2015/05/09.
 */
@Entity
public class Contact extends AbstractEntity {
    @Column
    private String tel;
    @OneToOne
    private Staff staff;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
