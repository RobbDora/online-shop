package ro.msg.learning.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.msg.learning.entities.ProductCategory;

@RepositoryRestResource
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    ProductCategory findProductCategoryByCategoryName(@Param("categoryName") String categoryName);

}

