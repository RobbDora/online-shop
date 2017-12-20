/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.msg.learning.strategies;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.dtos.OrderDTO;
import ro.msg.learning.dtos.OrderDetailsDTO;
import ro.msg.learning.entities.ProductLocationRelationship;
import ro.msg.learning.repositories.ProductLocationRelationshipRepository;

/**
 *
 * @author Dora Sara Robb
 */

public class SingleLocationStrategy implements OrderStrategy{

    private final ProductLocationRelationshipRepository productLocationRelationshipRepository;
    
    @Autowired
    public SingleLocationStrategy(ProductLocationRelationshipRepository productLocationRelationshipRepository){
        this.productLocationRelationshipRepository = productLocationRelationshipRepository;
    }
    
    @Override
    public Set<ProductLocationRelationship> handleOrders(OrderDTO orderdto) {
        List<Long> products = new ArrayList<>();
        Set<ProductLocationRelationship> prodLocationsStocks = new HashSet<>();
        List<Long> prodLocationStock = new ArrayList<>();
        short productStock;
        
        orderdto.getOrderDetailsProducts().forEach((orderDetails) -> {
            products.add(orderDetails.getProduct().getProductId());
        });

        List<Long> productLocationIds = productLocationRelationshipRepository.findAllProductsLocationsIn(products, (long)products.size());
        
        for(Long productLocationId : productLocationIds) {
            ProductLocationRelationship productLocation = new ProductLocationRelationship();
            for(OrderDetailsDTO order : orderdto.getOrderDetailsProducts()){
                productStock = productLocationRelationshipRepository.findStockForProduct(order.getProduct().getProductId(), productLocationId);
                //productLocation.setProduct(order.getProduct());
                productLocation.setStock(productStock);
                if(order.getQuantity() >= productStock) {
                    prodLocationStock.add(productLocationId);
                }
            }
            prodLocationsStocks.add(productLocation);
        }
        
        prodLocationStock.forEach((prodLocationId) -> {
            prodLocationsStocks.remove(prodLocationId);
        });
        
        return prodLocationsStocks;
    }
    
}
