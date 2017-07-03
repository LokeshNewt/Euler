package hibernate.entity;

import javax.persistence.*;

/**
 * Created by neerbans on 10/6/2016.
 */
@Entity
@Table(name = "Message")
public class Message {

    @Id
    @Column(name = "messageSid")
    private Long messageSid;

    @Column(name = "dataSource")
    private String dataSource;

    public Long getMessageSid() {
        return messageSid;
    }

    public void setMessageSid(Long messageSid) {
        this.messageSid = messageSid;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
}
