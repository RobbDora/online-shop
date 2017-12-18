/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.msg.learning.strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.dtos.OrderDTO;
import ro.msg.learning.dtos.OrderDetailsDTO;
import ro.msg.learning.entities.ProductLocationRelationship;
import ro.msg.learning.repositories.ProductLocationRelationshipRepository;

/**
 *
 * @author Dora Sara Robb
 */

public class GreedyStrategy implements OrderStrategy {
    
    
    private final ProductLocationRelationshipRepository productLocationRelationshipRepository;

    @Autowired
    public GreedyStrategy(ProductLocationRelationshipRepository productLocationRelationshipRepository){
        this.productLocationRelationshipRepository = productLocationRelationshipRepository;
    }
    
    @Override
    public Set<ProductLocationRelationship> handleOrders(OrderDTO orderdto) {
        List<Long> productIds = new ArrayList<>();
           
        for(OrderDetailsDTO orderDetails : orderdto.getOrderDetailsProducts()){
            productIds.add(orderDetails.getProduct().getProductId());
        }
        
        return null;
    }
    
}
