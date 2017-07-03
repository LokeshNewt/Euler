package mongoDb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
* Created by neerbans on 2/15/2016.
*/

@Document(collection = "employee")
public class User {

    @Id
    private String id;

    private String username;

    private String password;

    protected User() {}

    public User(String id, String firstName, String lastName) {
        this.id = id;
        this.username = firstName;
        this.password = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String firstName) {
        this.username = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String lastName) {
        this.password = lastName;
    }



}
