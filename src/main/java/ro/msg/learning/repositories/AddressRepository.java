package ro.msg.learning.repositories;

import org.springframework.data.repository.CrudRepository;
import ro.msg.learning.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Long>{

    Address findAddressByLocationStreetName(String streetName);

}
