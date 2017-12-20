package ro.msg.learning.strategies;

import ro.msg.learning.entities.Address;
import ro.msg.learning.models.DistanceObject;

import java.util.List;
import java.util.Set;

public interface DistanceComputation {

    List<DistanceObject> processResponse(Address shipAddress, List<Address> location);

}
