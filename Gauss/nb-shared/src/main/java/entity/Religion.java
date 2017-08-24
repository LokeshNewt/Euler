package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by neerbans on 22/4/17.
 */

@Entity
@Table(name = "Religion")
public class Religion extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "ReligionId")
    Long religionId;

    @Column(name = "God")
    String god;

    @Column(name = "HolyBook")
    String holyBook;

    @Column(name = "Name")
    String name;

    @ManyToMany(mappedBy = "religions")
    private Collection<Country> countries = new ArrayList<>();

    public Collection<Country> getCountries() {
        return countries;
    }

    public void setCountries(Collection<Country> countries) {
        this.countries = countries;
    }

    public Long getReligionId() {
        return religionId;
    }

    public void setReligionId(Long religionId) {
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
