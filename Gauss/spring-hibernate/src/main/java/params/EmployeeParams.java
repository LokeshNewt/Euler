package params;

import java.util.Date;

/**
 * Created by neerbans on 10/7/2016.
 */
public class EmployeeParams {

    private Long id;

    private String firstName;

    private String lastName;

    private String dept;

    private boolean flag;

    private Date createdDTTM;

    private Long messageSid;

    private Date updatedDTTM;

    public static EmployeeParams build() {
        return new EmployeeParams();
    }

    public Long getId() {
        return id;
    }

    public EmployeeParams setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeParams setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeParams setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDept() {
        return dept;
    }

    public EmployeeParams setDept(String dept) {
        this.dept = dept;
        return this;
    }

    public boolean isFlag() {
        return flag;
    }

    public EmployeeParams setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }

    public Date getCreatedDTTM() {
        return createdDTTM;
    }

    public EmployeeParams setCreatedDTTM(Date createdDTTM) {
        this.createdDTTM = createdDTTM;
        return this;
    }

    public Long getMessageSid() {
        return messageSid;
    }

    public EmployeeParams setMessageSid(Long messageSid) {
        this.messageSid = messageSid;
        return this;
    }

    public Date getUpdatedDTTM() {
        return updatedDTTM;
    }

    public EmployeeParams setUpdatedDTTM(Date updatedDTTM) {
        this.updatedDTTM = updatedDTTM;
        return this;
    }
}
