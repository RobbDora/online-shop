package ro.msg.learning.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @SequenceGenerator(name = "order_seq", sequenceName = "seq_order")
    @GeneratedValue(generator = "order_seq")
    @JsonProperty("OrderId")
    private Long orderId;

    @JsonProperty("ShipPostalCode")
    private String shipPostalCode;

    @JsonProperty("ShippedDate")
    private Timestamp shippedDate;

    @JsonProperty("OrderDate")
    private Timestamp orderDate;

    @JsonProperty("ShipRegion")
    private String shipRegion;

    @JsonProperty("Freight")
    private Double freight;

    @JsonProperty("ReguiredDate")
    private Timestamp requiredDate;

    @JsonProperty("ShipCity")
    private String shipCity;

    @JsonProperty("ShipCountry")
    private String shipCountry;

    @ManyToOne
    @JsonProperty("EmployeeID")
    private Employee employee;

    @JsonProperty("ShipVia")
    private Short shipVia;

    @ManyToOne
    @JsonProperty("CustomerID")
    private Customer customer;

    @JsonProperty("ShipAddress")
    private String shipAddress;

    @JsonProperty("ShipName")
    private String shipName;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetailsList = new ArrayList<>();
 
    public void addOrderDetails(OrderDetails orderDetails) {
        orderDetailsList.add(orderDetails);
        orderDetails.setOrder(this);
    }
 
    public void removeOrderDetails(OrderDetails orderDetails) {
        orderDetailsList.remove(orderDetails);
        orderDetails.setOrder(null);
    }
}
