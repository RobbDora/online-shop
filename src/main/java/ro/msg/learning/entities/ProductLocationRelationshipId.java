package ro.msg.learning.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ProductLocationRelationshipId implements Serializable{
    
    @Column(name = "product_Id")
    private Long productId;

    @Column(name = "location_Id")
    private Long locationId;

}
