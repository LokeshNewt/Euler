package shared.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by neerbans on 22/4/17.
 */

@Entity
@Table(name = "Religion")
public class Religion extends BaseEntity {

    @Id
    @Column(name = "ReligionId")
    String religionId;

    @Column(name = "God")
    String god;

    @Column(name = "HolyBook")
    String holyBook;

    @Column(name = "Name")
    String name;

    public String getReligionId() {
        return religionId;
    }

    public void setReligionId(String religionId) {
        this.religionId = religionId;
    }

    public String getGod() {
        return god;
    }

    public void setGod(String god) {
        this.god = god;
    }

    public String getHolyBook() {
        return holyBook;
    }

    public void setHolyBook(String holyBook) {
        this.holyBook = holyBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
