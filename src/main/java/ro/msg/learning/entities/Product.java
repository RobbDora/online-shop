package ro.msg.learning.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import ro.msg.learning.entities.types.Status;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product_table")
public class Product {

    @Id
    @SequenceGenerator(name = "prod_seq", sequenceName = "seq_product")
    @GeneratedValue(generator = "prod_seq")
    @JsonProperty("ProductId")
    private Long productId;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Status")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetails )) return false;
        return productId != null && productId.equals(((Product) o).productId);
    }
    @Override
    public int hashCode() {
        return 31;
    }

    @JsonProperty("SupplierName")
    private String supplierName;
    
    @Embedded
    @Basic(fetch = FetchType.LAZY)
    private ProductDetails productDetails;
}
