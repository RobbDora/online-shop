package ro.msg.learning.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Data
public class ProductLocationRelationship implements Serializable {
    
    @EmbeddedId
    private ProductLocationRelationshipId productLocationRelationshipId;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    @JsonProperty("product")
    private Product product;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "location_id", insertable = false, updatable = false)
    @JsonProperty("location")
    private Location location;

    @JsonProperty("stock")
    private short stock;
    
}
