package shared.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by neerbans on 21/4/17.
 */

@Entity
@Table(name = "Country")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "country")
public class Country extends BaseEntity implements Serializable {

    @Id
    @Column(name = "CountryId")
    private String countryId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Capital")
    private String capital;

    @Column(name = "Population")
    private String population;

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
