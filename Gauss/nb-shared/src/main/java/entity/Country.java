package entity;



import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by neerbans on 21/4/17.
 */

@Entity
@Table(name = "Country")
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "country")
public class Country extends BaseEntity implements Serializable {

    public Country() {}

    public Country(Long id) {
        this.countryId = id;
    }

    public Country(String name, String capital, Double population) {
        this.name = name;
        this.capital = capital;
        this.population = population;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CountryId")
    private Long countryId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Capital")
    private String capital;

    @Column(name = "Population")
    private Double population;

    @OneToOne
    @JoinColumn(name = "NationId")
    private Nation info;

    @OneToMany(cascade = CascadeType.PERSIST)//(mappedBy = "country")
    private Collection<Event> events = new ArrayList<>();

//    @OrderBy("name desc")
    @ManyToMany//(fetch = FetchType.EAGER)
//    @JoinTable(name = "Country_Religion", joinColumns = {@JoinColumn(name = "countryId")},
//            inverseJoinColumns = {@JoinColumn(name = "religionId")})
    private Collection<Religion> religions = new ArrayList<>();

    public Collection<Event> getEvents() {
        return events;
    }

    public void setEvents(Collection<Event> events) {
        this.events = events;
    }

    public Collection<Religion> getReligions() {
        return religions;
    }

    public void setReligions(List<Religion> religions) {
        this.religions = religions;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
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

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    public Nation getInfo() {
        return info;
    }

    public void setInfo(Nation info) {
        this.info = info;
    }
}
