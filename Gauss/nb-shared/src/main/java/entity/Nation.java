package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by neerbans on 8/22/2017.
 */

@Entity
public class Nation {

    @Id
    @GeneratedValue
    @Column(name = "NationId")
    private Long nationId;
    @Column(name = "PrimeMinister")
    private String prime_minister;
    @Column(name = "President")
    private String president;
    private Date independence_day;
    private String national_game;
    private String time_zone;
    private Float gdp;

    public Long getNationId() {
        return nationId;
    }

    public void setNationId(Long nationId) {
        this.nationId = nationId;
    }

    public String getPrime_minister() {
        return prime_minister;
    }

    public void setPrime_minister(String prime_minister) {
        this.prime_minister = prime_minister;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public Date getIndependence_day() {
        return independence_day;
    }

    public void setIndependence_day(Date independence_day) {
        this.independence_day = independence_day;
    }

    public String getNational_game() {
        return national_game;
    }

    public void setNational_game(String national_game) {
        this.national_game = national_game;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public Float getGdp() {
        return gdp;
    }

    public void setGdp(Float gdp) {
        this.gdp = gdp;
    }
}
