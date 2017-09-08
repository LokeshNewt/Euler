package entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

/**
 * Created by neerbans on 15/8/17.
 */

@Entity(name = "Event")
//@Embeddable
public class Event extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "EventId")
    private Long eventId;

//    @Lob
    @Column(name = "Description")
    private String desc;
    @Column(name = "Place")
    private String place;
    @Column(name = "Type")
    private String type;

//    @ManyToOne
////    @NotFound(action = NotFoundAction.IGNORE)
////    @JoinColumn(name = "CountryId")
//    private Country country;

//    public Country getCountry() {
//        return country;
//    }
//
//    public void setCountry(Country country) {
//        this.country = country;
//    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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
