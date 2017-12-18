package ro.msg.learning.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.msg.learning.entities.Customer;
import ro.msg.learning.entities.Order;

import java.util.List;


@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer, String>{

    Customer findByAddress(@Param("address") String address);

    List<Customer> findCustomersByCompanyName(@Param("companyName") String companyName);

    List<Customer> findCustomersByAddress(@Param("address") String address);

    List<Customer> findCustomersByOrders(@Param("orders") List<Order> orders);

}
