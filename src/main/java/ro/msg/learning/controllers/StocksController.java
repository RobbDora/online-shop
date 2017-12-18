/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.msg.learning.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.dtos.ProductDTO;
import ro.msg.learning.dtos.ProductLocationRelationshipDTOWrapper;
import ro.msg.learning.services.StockService;

/**
 *
 * @author Dora Sara Robb
 */

@RestController
@RequestMapping("/stocks")
public class StocksController {
    
    private final StockService stockService;
    
    @Autowired
    public StocksController(StockService stockService){
        this.stockService = stockService;
    }
    
    @PostMapping(value = "/importStocks/{locationId}", consumes = "text/csv")
    public void importStocks(@PathVariable("locationId") Long locationId, 
                             @RequestBody ProductLocationRelationshipDTOWrapper productdtoWrapper){
        stockService.importStocks(locationId, productdtoWrapper);
    }
    
    @GetMapping(value = "/exportStocks/{locationId}", produces = "application/json")
    public List<ProductDTO> exportStocks(@PathVariable("locationId") Long locationId){
        List<ProductDTO> productLocations = stockService.exportStocks(locationId);
        return productLocations;
    }
    
    @GetMapping(value = "/exportStocks", produces = "application/json")
    public List<ProductDTO> exportWholeStock(){
        List<ProductDTO> wholeStockProductLocations = stockService.exportWholeStock();
        return wholeStockProductLocations;
    }
}
