package hibernate.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by neerbans on 10/29/2015.
 */

@Entity
@Table(name = "Employee")
@AttributeOverride(name = "product", column = @Column(name = "product"))
public class Employee extends BaseEntity implements Serializable {

    @Id
    @Column(name = "employeeId")
    private Long employeeId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

//    @Basic(optional = false)
//@Temporal(TemporalType.TIMESTAMP)

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDTTM")
    private Date createdDTTM;

    @Column(name = "updatedDTTM")
    private Date updatedDTTM;

    @Type(type = "true_false")
    @Column(name = "exclusionFlag")
    private boolean exclusionFlag;

//    @Column(name = "MessageSid")
//    private Long messageSid;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "empId", referencedColumnName = "employeeId")
    private List<EmpAddress> empAddresses;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MessageSid", referencedColumnName = "MessageSid")
    private Message message;

    @OrderBy("name desc")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "EmployeeProduct", joinColumns = {@JoinColumn(name = "employeeId")},
    inverseJoinColumns = {@JoinColumn(name = "productId")})
    private List<Product> products;

    public Employee() {}

    public Employee(Long employeeId, String firstName, String lastName, String product) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.product = product;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getProduct() {
//        return product;
//    }
//
//    public void setProduct(String product) {
//        this.product = product;
//    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Date getCreatedDTTM() {
        return createdDTTM;
    }

    public void setCreatedDTTM(Date createdDTTM) {
        this.createdDTTM = createdDTTM;
    }

    public boolean isExclusionFlag() {
        return exclusionFlag;
    }

    public void setExclusionFlag(boolean exclusionFlag) {
        this.exclusionFlag = exclusionFlag;
    }

    public Date getUpdatedDTTM() {
        return updatedDTTM;
    }

    public void setUpdatedDTTM(Date updatedDTTM) {
        this.updatedDTTM = updatedDTTM;
    }

    public List<EmpAddress> getEmpAddresses() {
        return empAddresses;
    }

    public void setEmpAddresses(List<EmpAddress> empAddresses) {
        this.empAddresses = empAddresses;
    }

    //        public Long getMessageSid() {
//        return messageSid;
//    }

//    public void setMessageSid(Long messageSid) {
//        this.messageSid = messageSid;
//    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
