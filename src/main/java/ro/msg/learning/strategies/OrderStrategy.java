package ro.msg.learning.strategies;


import java.util.Set;

import ro.msg.learning.dtos.OrderDTO;
import ro.msg.learning.entities.ProductLocationRelationship;


public interface OrderStrategy {

    Set<ProductLocationRelationship> handleOrders(OrderDTO orderdto);

}
