package ro.msg.learning.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.msg.learning.models.types.ElementStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Element {

    @JsonProperty("status")
    private ElementStatus status;

    @JsonProperty("distance")
    private TextValue distance;

    @JsonProperty("duration")
    private TextValue duration;

}
