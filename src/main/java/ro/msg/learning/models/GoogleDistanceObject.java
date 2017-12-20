package ro.msg.learning.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ro.msg.learning.models.types.TopLevelStatus;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GoogleDistanceObject {

    @JsonProperty("destination_addresses")
    private List<String> destinationAddresses= new ArrayList<>();

    @JsonProperty("origin_addresses")
    private List<String> originAddresses= new ArrayList<>();

    @JsonProperty("rows")
    private List<Rows> rows = new ArrayList<>();

    @JsonProperty("status")
    private TopLevelStatus status;

}
