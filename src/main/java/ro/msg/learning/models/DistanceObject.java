package ro.msg.learning.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DistanceObject {

    @JsonProperty("OriginAddress")
    private String originAddress;

    @JsonProperty("DestinationAddress")
    private String destinationAddress;

    @JsonProperty("Distance")
    private String distance;
}
