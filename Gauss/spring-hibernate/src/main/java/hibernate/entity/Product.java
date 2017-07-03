package hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by neerbans on 9/4/17.
 */
@Table
@Entity(name = "Product")
public class Product {

    @Id
    @Column(name = "productId")
    Long productId;

    @Column(name = "primaryClient")
    String primaryClient;

    @Column(name = "clientCount")
    Integer clientCount;

    @Column(name = "name")
    String name;

    @Column(name = "lastRelease")
    String lastRelease;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getPrimaryClient() {
        return primaryClient;
    }

    public void setPrimaryClient(String primaryClient) {
        this.primaryClient = primaryClient;
    }

    public Integer getClientCount() {
        return clientCount;
    }

    public void setClientCount(Integer clientCount) {
        this.clientCount = clientCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastRelease() {
        return lastRelease;
    }

    public void setLastRelease(String lastRelease) {
        this.lastRelease = lastRelease;
    }
}
