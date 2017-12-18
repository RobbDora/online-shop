/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.msg.learning.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ro.msg.learning.entities.Order;
import ro.msg.learning.repositories.OrderRepository;
import ro.msg.learning.strategies.OrderStrategy;

import ro.msg.learning.dtos.OrderDTO;
import ro.msg.learning.dtos.OrderDetailsDTO;
import ro.msg.learning.entities.ProductLocationRelationship;
import ro.msg.learning.repositories.ProductLocationRelationshipRepository;

import javax.transaction.Transactional;

/**
 *
 * @author Dora Sara Robb
 */

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderStrategy orderStrategy;
    private final ProductLocationRelationshipRepository productLocationRelationshipRepository;

    @Autowired
    public OrderService(OrderStrategy orderStrategy, ProductLocationRelationshipRepository productLocationRelationshipRepository, OrderRepository orderRepository){

        this.orderStrategy = orderStrategy;
        this.productLocationRelationshipRepository = productLocationRelationshipRepository;
        this.orderRepository = orderRepository;
        
    }

    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public Order createOrder(OrderDTO orderdto){
        Order createdOrder = new Order();
        createdOrder.setOrderDate(orderdto.getOrderDate());
        createdOrder.setShipAddress(orderdto.getShipAddress());
        
        Set<ProductLocationRelationship> productLocations = orderStrategy.handleOrders(orderdto);
        
        for(ProductLocationRelationship productLocation : productLocations){
            Long locationId = productLocation.getLocation().getLocationId();
            for(OrderDetailsDTO orderDetail : orderdto.getOrderDetailsProducts()){
                ProductLocationRelationship productLocationItem = productLocationRelationshipRepository.findByLocation_LocationId(locationId);
                if(productLocationItem.getStock() > orderDetail.getQuantity()){
                    productLocationItem.setStock((short) (productLocationItem.getStock() - orderDetail.getQuantity())); 
                }
                productLocationRelationshipRepository.save(productLocationItem);
            }
        }
        return orderRepository.save(createdOrder);
    }

}
