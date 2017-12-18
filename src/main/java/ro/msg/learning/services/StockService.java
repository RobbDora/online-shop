/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.msg.learning.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ro.msg.learning.dtos.ProductDTO;
import ro.msg.learning.dtos.ProductLocationRelationshipDTO;
import ro.msg.learning.dtos.ProductLocationRelationshipDTOWrapper;
import ro.msg.learning.entities.ProductLocationRelationship;
import ro.msg.learning.entities.ProductLocationRelationshipId;
import ro.msg.learning.repositories.ProductLocationRelationshipRepository;

/**
 *
 * @author Dora Sara Robb
 */

@Service
public class StockService {

    private final ProductLocationRelationshipRepository productLocationRelationshipRepository;

    @Autowired
    public StockService(ProductLocationRelationshipRepository productLocationRelationshipRepository){
        this.productLocationRelationshipRepository = productLocationRelationshipRepository;
    }

    public void importStocks(Long locationId, ProductLocationRelationshipDTOWrapper wrapper){

        for(ProductLocationRelationshipDTO productLocations : wrapper.getProductLocationRelationshipDTOs()){
            ProductLocationRelationshipId id = new ProductLocationRelationshipId();
            id.setProductId(productLocations.getProduct().getProductId());
            id.setLocationId(locationId);
            ProductLocationRelationship product = productLocationRelationshipRepository.findOne(id);
            product.setStock((short) (productLocations.getStock()+ product.getStock()));
            productLocationRelationshipRepository.save(product);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ProductDTO> exportStocks(Long locationId){
        Iterable<ProductLocationRelationship> stocksPerLocation = productLocationRelationshipRepository.findByProductLocationRelationshipId_LocationId(locationId);
        return getProductDTO(stocksPerLocation);
    }
    
    public List<ProductDTO> exportWholeStock(){
        Iterable<ProductLocationRelationship> wholeStockOfTheStore = productLocationRelationshipRepository.findAll();
        return getProductDTO(wholeStockOfTheStore);
    }

    private List<ProductDTO> getProductDTO(Iterable<ProductLocationRelationship> productLocations){
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(ProductLocationRelationship stocks : productLocations){
            ProductDTO product = new ProductDTO();
            product.setProductId(stocks.getProduct().getProductId());
            product.setStock(stocks.getStock());
            productDTOList.add(product);
        }
        return productDTOList;
    }
}
