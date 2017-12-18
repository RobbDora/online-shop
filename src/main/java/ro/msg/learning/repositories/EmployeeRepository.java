package ro.msg.learning.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.msg.learning.entities.Employee;
import ro.msg.learning.entities.ProductLocationRelationship;

import java.util.List;
import java.util.Set;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByFirstName(@Param("firstName") String firstName);

    List<Employee> findEmployeesByFirstName(@Param("firstName") String firstName);

    void save(Set<ProductLocationRelationship> productLocationRelationships);

}
