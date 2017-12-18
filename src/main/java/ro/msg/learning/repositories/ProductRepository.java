package ro.msg.learning.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.msg.learning.entities.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

   //List<Product> findByName(@Param("name") String name);

   //List<Product> findProductsByCategory(@Param("category") String category);
   
}

