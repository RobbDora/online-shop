package ro.msg.learning.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TextValue {

    @JsonProperty("text")
    private String text;

    @JsonProperty("value")
    private String value;

}
