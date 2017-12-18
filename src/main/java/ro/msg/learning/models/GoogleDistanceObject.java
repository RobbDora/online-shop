package ro.msg.learning.models;


import lombok.Data;

import java.util.List;

@Data
public class GoogleDistanceObject {

    private List<String> destinationAddresses;

    private List<String> originAddresses;

    private List<Rows> rows;

}
