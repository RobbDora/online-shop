/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.msg.learning.dtos;

import java.sql.Timestamp;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Dora Sara Robb
 */

@Data
public class OrderDTO {
    
    private List<OrderDetailsDTO> orderDetailsProducts;
    
    private String shipAddress;
    
    private Timestamp orderDate;
    
}
