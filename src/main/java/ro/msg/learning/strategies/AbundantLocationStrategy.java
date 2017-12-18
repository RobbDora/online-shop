/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.msg.learning.strategies;

import java.util.HashSet;
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
public class AbundantLocationStrategy implements OrderStrategy {

    private ProductLocationRelationshipRepository productLocationRelationshipRepository;
    
    @Autowired
    public AbundantLocationStrategy(ProductLocationRelationshipRepository productLocationRelationshipRepository){
        this.productLocationRelationshipRepository = productLocationRelationshipRepository;
    }

    @Override
    public Set<ProductLocationRelationship> handleOrders(OrderDTO orderdto) {
        Set<ProductLocationRelationship> productLocationsWithLargestStock = new HashSet<>();

        for(OrderDetailsDTO orderDetailsdto : orderdto.getOrderDetailsProducts()){
           ProductLocationRelationship  productLocationWithMaxStock = productLocationRelationshipRepository.findMaxStockForProduct(orderDetailsdto.getProduct().getProductId());
           productLocationsWithLargestStock.add(productLocationWithMaxStock);
        }
        
        return productLocationsWithLargestStock;
    }

}
