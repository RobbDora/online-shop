package ro.msg.learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.msg.learning.entities.OrderDetails;

@RepositoryRestResource
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, String> {

    OrderDetails findOrderDetailsByProduct(@Param("product") String product);

}
