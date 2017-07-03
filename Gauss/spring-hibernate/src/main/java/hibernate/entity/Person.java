package hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by neerbans on 11/3/2016.
 */

@Entity
@Table(name = "Person")
public class Person implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
