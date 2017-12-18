/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.msg.learning.shop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.msg.learning.entities.ProductLocationRelationship;
import ro.msg.learning.repositories.ProductLocationRelationshipRepository;

/**
 *
 * @author Dora Sara Robb
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class AbudantLocationStrategyTest {
    
    //private final Logger log = LoggerFactory.getLogger(SingleLocationTest.class);
    
    @Autowired
    private ProductLocationRelationshipRepository productLocationRelationshipRepository;
    
    @Test
    public void testOrder(){
        ProductLocationRelationship prodLoc;
        prodLoc = productLocationRelationshipRepository.findMaxStockForProduct(2L);
        //log.info(String.valueOf(prodLoc.getStock()));
    }
    
}
