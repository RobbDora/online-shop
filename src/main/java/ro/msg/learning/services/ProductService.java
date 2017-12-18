package ro.msg.learning.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ro.msg.learning.dtos.ProductLocationRelationshipDTO;
import ro.msg.learning.entities.Location;
import ro.msg.learning.entities.Product;
import ro.msg.learning.entities.ProductLocationRelationship;
import ro.msg.learning.entities.types.Status;
import ro.msg.learning.repositories.ProductLocationRelationshipRepository;

/**
*
* @author Dora Sara Robb
*/
@Service
public class ProductService {

  private final ProductLocationRelationshipRepository productLocationRelationshipRepository;

  @Autowired
   public ProductService(ProductLocationRelationshipRepository productLocationRelationshipRepository){
      this.productLocationRelationshipRepository = productLocationRelationshipRepository;
    }

    @PreAuthorize("hasAuthority('USER')")
    public List<ProductLocationRelationshipDTO> findListOfProducts(){
       List<ProductLocationRelationshipDTO> listOfProd = new ArrayList<>();

       for(ProductLocationRelationship productLocation : productLocationRelationshipRepository.findAll()) {
           ProductLocationRelationshipDTO productLocationRelationshipDTO = new ProductLocationRelationshipDTO();
           Location location = new Location();
           Product product = new Product();
           location.setLocationId(productLocation.getLocation().getLocationId());
           location.setAddress(productLocation.getLocation().getAddress());
           product.setProductId(productLocation.getProduct().getProductId());
           product.setName(productLocation.getProduct().getName());
           product.setProductDetails(productLocation.getProduct().getProductDetails());
           product.setSupplierName(productLocation.getProduct().getSupplierName());
           productLocationRelationshipDTO.setProduct(product);
           productLocationRelationshipDTO.setStock(productLocation.getStock());
           productLocationRelationshipDTO.setLocation(location);
           listOfProd.add(productLocationRelationshipDTO);
     }
      setStatus(listOfProd);
      return listOfProd;
  }

  public static void setStatus(List<ProductLocationRelationshipDTO> listOfProd){
      for(ProductLocationRelationshipDTO productLocation : listOfProd){
          if(productLocation.getStock() == 0){
              productLocation.getProduct().setStatus(Status.OUT_OF_STOCK);
          }else
             productLocation.getProduct().setStatus(Status.IN_STOCK);
   }
  }

}
