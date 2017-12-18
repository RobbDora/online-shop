package ro.msg.learning.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.msg.learning.entities.Order;

@RepositoryRestResource
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {


}
