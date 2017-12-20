package ro.msg.learning.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "address_table")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @JsonProperty("City")
    private String city;

    @JsonProperty("Country")
    private String country;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Location location;

    @OneToMany(mappedBy = "address")
    @JsonProperty("Customer")
    private List<Customer> customer = new ArrayList<>();
}
