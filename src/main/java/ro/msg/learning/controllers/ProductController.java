package ro.msg.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.dtos.ProductLocationRelationshipDTO;
import ro.msg.learning.services.ProductService;

import java.util.List;

/**
*
* @author Dora Sara Robb
 * */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/viewListOfProducts")
    public List<ProductLocationRelationshipDTO> viewListOfProducts(){
        return productService.findListOfProducts();
    }

}
