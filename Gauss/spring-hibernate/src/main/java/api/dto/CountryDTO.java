package api.dto;

import shared.CustomDate;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by neerbans on 10/13/2016.
 */

//@XmlRootElement(name = "employee")
//@XmlType(propOrder = {"updatedDTTM", "createdDTTM"})
//@XmlAccessorType(XmlAccessType.FIELD)
public class CountryDTO implements Serializable{

    private Long id;

    @XmlAttribute
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Date createdDTTM;

    @XmlElement
    public Date getCreatedDTTM() {
        return createdDTTM;
    }

    public void setCreatedDTTM(Date createdDTTM) {
        this.createdDTTM = createdDTTM;
    }

    private CustomDate updatedDTTM;

    @XmlElement
    public CustomDate getUpdatedDTTM() {
        return updatedDTTM;
    }

    public void setUpdatedDTTM(CustomDate updatedDTTM) {
        this.updatedDTTM = updatedDTTM;
    }


    // when you convert from list to set, it will filter records if id is same
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CountryDTO other = (CountryDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
