/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.msg.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.dtos.OrderDTO;
import ro.msg.learning.entities.Order;
import ro.msg.learning.services.OrderService;

/**
 *
 * @author Dora Sara Robb
 */

@RestController
@RequestMapping(value = "/orders")
public class OrdersController {
    
    private final OrderService orderService;
    
    @Autowired
    public OrdersController(OrderService orderService){
        this.orderService = orderService;
    }
   
    @PostMapping(value = "/createOrder")
    public Order createOrder(@RequestBody OrderDTO orderdto){
        return orderService.createOrder(orderdto);
    }
}
