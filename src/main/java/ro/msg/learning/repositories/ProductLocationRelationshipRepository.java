/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.msg.learning.repositories;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.msg.learning.entities.Location;
import ro.msg.learning.entities.ProductLocationRelationship;
import ro.msg.learning.entities.ProductLocationRelationshipId;

/**
 *
 * @author Dora Sara Robb
 */

@RepositoryRestResource
public interface ProductLocationRelationshipRepository extends CrudRepository<ProductLocationRelationship, ProductLocationRelationshipId>{
    
   @Query(value = "Select m.* from MAX_STOCK m where m.product_id = :productId", nativeQuery = true)
   ProductLocationRelationship findMaxStockForProduct(@Param("productId") Long productId);
    
   @Query(value = "select p.location.locationId from ProductLocationRelationship p where p.product.productId in :productIds group by p.location.locationId having count(p.product.productId) = :sumProducts")
   List<Long> findAllProductsLocationsIn(@Param("productIds") List<Long> productIds, @Param("sumProducts") Long sumProducts);

   @Query(value = "Select p.stock from product_location_relationship p where p.product_id = :productId and p.location_id = :locationId order by p.location_id", nativeQuery = true)
   Short findStockForProduct(@Param("productId") Long productId, @Param("locationId") Long locationId);
   
   @Query(value = "Select p.location from ProductLocationRelationship p where p.product.productId in :productIds order by p.location.locationId asc")
   Set<Location> loadAllLocations(@Param("productIds") List<Long> productIds);

   List<ProductLocationRelationship> findByProductLocationRelationshipId_LocationId(Long locationId);

   ProductLocationRelationship findByLocation_LocationId(Long locationId);

}
