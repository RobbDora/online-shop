/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.msg.learning.dtos;

import java.util.List;

/**
 *
 * @author Dora Sara Robb
 */
public class ProductLocationRelationshipDTOWrapper {
    
    private List<ProductLocationRelationshipDTO> productLocationRelationshipDTOs;

    public List<ProductLocationRelationshipDTO> getProductLocationRelationshipDTOs() {
        return productLocationRelationshipDTOs;
    }
    
    public void setPersons(List<ProductLocationRelationshipDTO> productLocationRelationshipDTOs) {
        this.productLocationRelationshipDTOs = productLocationRelationshipDTOs;
    }
}
