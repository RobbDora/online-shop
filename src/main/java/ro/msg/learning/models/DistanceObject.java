package ro.msg.learning.models;

import lombok.Data;
import ro.msg.learning.entities.Address;
import ro.msg.learning.models.types.TopLevelStatus;

import java.util.ArrayList;
import java.util.List;

@Data
public class DistanceObject {

    private String originAddress;

    private String destinationAddress;

    private long distance;
}
