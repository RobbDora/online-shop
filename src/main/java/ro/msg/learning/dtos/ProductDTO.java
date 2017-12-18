/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.msg.learning.dtos;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

/**
 *
 * @author Dora Sara Robb
 */
@Data
public class ProductDTO {
    
    @CsvBindByName
    private Long productId;
    @CsvBindByName
    private String name;

    private short stock;
}
