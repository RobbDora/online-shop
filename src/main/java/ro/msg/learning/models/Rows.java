package ro.msg.learning.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rows {

    @JsonProperty("elements")
    private List<Element> elementList;

}
