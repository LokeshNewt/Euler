package entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by neerbans on 4/11/2017.
 */
@MappedSuperclass
public class  BaseEntity implements Serializable {

//    @Temporal(TemporalType.DATE)
    @Column(name = "CreatedDate")
    private Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
