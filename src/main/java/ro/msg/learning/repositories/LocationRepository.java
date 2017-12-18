package ro.msg.learning.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.msg.learning.entities.Location;

@RepositoryRestResource
public interface LocationRepository extends CrudRepository<Location, Long> {

}
