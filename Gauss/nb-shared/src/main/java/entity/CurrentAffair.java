package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by neerbans on 15/8/17.
 */

@Entity
public class CurrentAffair extends BaseEntity {

    @Id
    @Column(name = "CurrentAffairId")
    private Long currentAffairId;

    @Column(name = "Desc")
    private String desc;
    @Column(name = "Place")
    private String place;
    @Column(name = "Type")
    private String type;

    @ManyToOne
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getCurrentAffairId() {
        return currentAffairId;
    }

    public void setCurrentAffairId(Long currentAffairId) {
        this.currentAffairId = currentAffairId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
