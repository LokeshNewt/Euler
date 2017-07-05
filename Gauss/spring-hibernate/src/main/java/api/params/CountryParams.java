package api.params;

import java.util.Date;

/**
 * Created by neerbans on 10/7/2016.
 */
public class CountryParams {

    private Long id;

    private String firstName;

    private String lastName;

    private String dept;

    private boolean flag;

    private Date createdDTTM;

    private Long messageSid;

    private Date updatedDTTM;

    public static CountryParams build() {
        return new CountryParams();
    }

    public Long getId() {
        return id;
    }

    public CountryParams setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CountryParams setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CountryParams setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDept() {
        return dept;
    }

    public CountryParams setDept(String dept) {
        this.dept = dept;
        return this;
    }

    public boolean isFlag() {
        return flag;
    }

    public CountryParams setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }

    public Date getCreatedDTTM() {
        return createdDTTM;
    }

    public CountryParams setCreatedDTTM(Date createdDTTM) {
        this.createdDTTM = createdDTTM;
        return this;
    }

    public Long getMessageSid() {
        return messageSid;
    }

    public CountryParams setMessageSid(Long messageSid) {
        this.messageSid = messageSid;
        return this;
    }

    public Date getUpdatedDTTM() {
        return updatedDTTM;
    }

    public CountryParams setUpdatedDTTM(Date updatedDTTM) {
        this.updatedDTTM = updatedDTTM;
        return this;
    }
}
