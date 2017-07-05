package shared.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by neerbans on 4/11/2017.
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Column(name = "createdDate")
    Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
