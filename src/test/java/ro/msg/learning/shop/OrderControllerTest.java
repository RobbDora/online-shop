//package ro.msg.learning.shop;
//
//
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runner.manipulation.Filter;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.test.context.support.WithAnonymousUser;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.security.test.context.support.WithUserDetails;
//import org.springframework.security.web.FilterChainProxy;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import ro.msg.learning.dtos.OrderDTO;
//import ro.msg.learning.dtos.OrderDetailsDTO;
//import ro.msg.learning.entities.Order;
//import ro.msg.learning.entities.Product;
//import ro.msg.learning.entities.User;
//import ro.msg.learning.entities.UserRole;
//import ro.msg.learning.security.AuthorizationServerConfig;
//
///**
// *
// * @author Dora Sara Robb
// */
//@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class OrderControllerTest {
//
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//
//    @Test
//    public void orderControllerTest(){
//        OrderDTO order = new OrderDTO();
//        Product product1 = new Product();
//        Product product2 = new Product();
//        product1.setProductId(9L);
//        product1.setName("Laptop");
//        product2.setProductId(3L);
//        product2.setName("Notebook");
//        List<OrderDetailsDTO> orderDetailsList = new ArrayList<>();
//        OrderDetailsDTO orderDetails = new OrderDetailsDTO();
//        orderDetails.setProduct(product1);
//        orderDetails.setProduct(product2);
//        orderDetailsList.add(orderDetails);
//        order.setShipAddress("Cantemir");
//        order.setOrderDetailsProducts(orderDetailsList);
//        ResponseEntity<Order> response = testRestTemplate.postForEntity("/orders/createOrder", order, Order.class);
//        log.info(response.getBody().toString());
//        Assert.assertEquals(MediaType.APPLICATION_JSON_UTF8, response.getHeaders().getContentType());
//        Assert.assertTrue(response.getStatusCode().is2xxSuccessful());
//    }
//
//    @Test
//    public void orderProductNotFoundControllerTest(){
//        OrderDTO order = new OrderDTO();
//        Product product1 = new Product();
//        Product product2 = new Product();
//        product2.setProductId(1L);
//        product2.setName("Notebook");
//        product1.setProductId(4L);
//        product1.setName("Laptop");
//        List<OrderDetailsDTO> orderDetailsList = new ArrayList<>();
//        OrderDetailsDTO orderDetails = new OrderDetailsDTO();
//        OrderDetailsDTO orderDetails2 = new OrderDetailsDTO();
//        orderDetails2.setProduct(product1);
//        orderDetails.setProduct(product2);
//        orderDetailsList.add(orderDetails);
//        order.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));
//        order.setShipAddress("Crinului");
//        order.setOrderDetailsProducts(orderDetailsList);
//        ResponseEntity<Order> response = testRestTemplate.postForEntity("/orders/createOrder", order, Order.class);
//        log.info(response.getBody().toString());
//        Assert.assertEquals(MediaType.APPLICATION_JSON_UTF8, response.getHeaders().getContentType());
//        Assert.assertTrue(response.getStatusCode().is2xxSuccessful());
//    }
//
//    @Test
//    public void orderQuantityExceedsStockControllerTest(){
//        OrderDTO order = new OrderDTO();
//        Product product1 = new Product();
//        Product product2 = new Product();
//        product2.setProductId(1L);
//        product2.setName("Notebook");
//        product1.setProductId(4L);
//        product1.setName("Laptop");
//        List<OrderDetailsDTO> orderDetailsList = new ArrayList<>();
//        OrderDetailsDTO orderDetails = new OrderDetailsDTO();
//        OrderDetailsDTO orderDetails2 = new OrderDetailsDTO();
//        orderDetails2.setProduct(product2);
//        orderDetails.setProduct(product1);
//        orderDetails.setQuantity((short)100000);
//        order.setShipAddress("Salciei");
//        order.setOrderDetailsProducts(orderDetailsList);
//        ResponseEntity<Order> response = testRestTemplate.postForEntity("/orders/createOrder", order, Order.class);
//        log.info(response.getBody().toString());
//        Assert.assertEquals(MediaType.APPLICATION_JSON_UTF8, response.getHeaders().getContentType());
//        Assert.assertTrue(response.getStatusCode().is2xxSuccessful());
//    }
//}
