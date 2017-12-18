/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.msg.learning.dtos;

import lombok.Data;
import ro.msg.learning.entities.Product;

/**
 *
 * @author Dora Sara Robb
 */
@Data
public class OrderDetailsDTO {

    private Short quantity;

    private ProductDTO product;

}
