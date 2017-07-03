package store.entity;

import hibernate.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by neerbans on 21/4/17.
 */

@Entity
@Table(name = "Country")
public class Country extends BaseEntity {

    @Id
    @Column(name = "CountryId")
    String countryId;

    @Column(name = "Name")
    String name;

    @Column(name = "Capital")
    String capital;

    @Column(name = "Population")
    String population;

    @OrderBy("name desc")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CountryReligion", joinColumns = {@JoinColumn(name = "countryId")},
            inverseJoinColumns = {@JoinColumn(name = "religionId")})
    private List<Religion> religions;

    public List<Religion> getReligions() {
        return religions;
    }

    public void setReligions(List<Religion> religions) {
        this.religions = religions;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
