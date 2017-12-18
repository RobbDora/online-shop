package ro.msg.learning.strategies;

import ro.msg.learning.entities.Address;
import ro.msg.learning.models.DistanceObject;

import java.util.List;

public interface DistanceComputation {

    DistanceObject computeDistance(String shipAddress, List<Address> location);

}
