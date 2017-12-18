//package ro.msg.learning.shop;
//
//
//import java.util.*;
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import ro.msg.learning.dtos.OrderDTO;
//import ro.msg.learning.dtos.OrderDetailsDTO;
//import ro.msg.learning.entities.Product;
//import ro.msg.learning.repositories.ProductLocationRelationshipRepository;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@DataJpaTest
//public class SingleLocationTest {
//
//    private final Logger log = LoggerFactory.getLogger(SingleLocationTest.class);
//
//    @Autowired
//    private ProductLocationRelationshipRepository productLocationRelationshipRepository;
//
//    @Test
//    public void testOrder(){
//        OrderDTO orderdto = new OrderDTO();
//        List<OrderDetailsDTO> orderD = new ArrayList<>();
//        OrderDetailsDTO orderDetails = new OrderDetailsDTO();
//        OrderDetailsDTO orderDetails1 = new OrderDetailsDTO();
//        Product p = new Product();
//        Product p2 = new Product();
//        p.setProductId(1L);
//        p2.setProductId(3L);
//        orderDetails.setProduct(p);
//        orderDetails1.setProduct(p2);
//        orderDetails1.setQuantity((short)3);
//        orderDetails.setQuantity((short)4000);
//        orderD.add(orderDetails);
//        orderD.add(orderDetails1);
//        orderdto.setOrderDetailsProducts(orderD);
//        List<Long> productIds = new ArrayList<>();
//        productIds.add(1L);
//        productIds.add(3L);
//        List<Long> prodLoc = productLocationRelationshipRepository.findAllProductsLocationsIn(productIds, (long)productIds.size());
//        log.info(prodLoc.toString());
//        assertNotNull(prodLoc.get(0));
//
//    }
//
//
//}
