package ro.msg.learning.strategies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
import ro.msg.learning.entities.Address;
import ro.msg.learning.models.DistanceObject;
import ro.msg.learning.models.GoogleDistanceObject;

import java.util.*;


@Slf4j
public class AbstractGoogleDistance implements DistanceComputation{

    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String url;

    public AbstractGoogleDistance(String url, String apiKey, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
        this.url = url;
    }

    @Override
    public List<DistanceObject> processResponse(Address shipAddress, List<Address> destinations) {
        List<DistanceObject> distanceObjectList = new ArrayList<>();

        for(Address destinationAddress : destinations) {

            DistanceObject distanceObject = new DistanceObject();
            GoogleDistanceObject googleResponse = restTemplate.getForObject(url, GoogleDistanceObject.class, shipAddress.getLocation().getStreetName() + "," + shipAddress.getCity() + "," + shipAddress.getCountry() + ",", destinationAddress.getLocation().getStreetName() + "," + destinationAddress.getCity() + "," + destinationAddress.getCountry(), apiKey);
            distanceObject.setDestinationAddress(googleResponse.getDestinationAddresses().get(0));
            distanceObject.setOriginAddress(googleResponse.getOriginAddresses().get(0));
            distanceObject.setDistance(googleResponse.getRows().get(0).getElementList().get(0).getDistance().getText());
            distanceObjectList.add(distanceObject);

        }
        distanceObjectList.sort(Comparator.comparing(DistanceObject::getDistance));

        return distanceObjectList;
    }
}

