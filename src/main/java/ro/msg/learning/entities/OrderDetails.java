package ro.msg.learning.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_details_table")
public class OrderDetails {

    @Id
    @SequenceGenerator(name = "orderDetails_seq", sequenceName = "seq_orderDetails")
    @GeneratedValue(generator = "orderDetails_seq")
    @JsonProperty("OrderDetailsId")
    private Long orderDetailsId;

    @JsonProperty("Quantity")
    private Short quantity;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonProperty("Product")
    private Product product;

    @JsonProperty("Discount")
    private Double discount;

    @JsonProperty("UnitPrice")
    private Double unitPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetails )) return false;
        return orderDetailsId != null && orderDetailsId.equals(((OrderDetails) o).orderDetailsId);
    }
    @Override
    public int hashCode() {
        return 31;
    }

}
