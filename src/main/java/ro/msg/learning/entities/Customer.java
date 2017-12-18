package ro.msg.learning.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "customer_table")
public class Customer {

    @Id
    @JsonProperty("CustomerId")
    private String customerId;

    @Column(unique = true)
    @JsonProperty("CompanyName")
    private String companyName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
