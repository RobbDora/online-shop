package ro.msg.learning.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ro.msg.learning.entities.Address;

import javax.persistence.*;

@Data
@Entity
@Table(name = "location_table")
public class Location {

    @Id
    @SequenceGenerator(name = "location_seq", sequenceName = "seq_location")
    @GeneratedValue(generator = "location_seq")
    @JsonProperty("LocationId")
    private Long locationId;

    @JsonProperty("StreetName")
    private String streetName;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    
}
