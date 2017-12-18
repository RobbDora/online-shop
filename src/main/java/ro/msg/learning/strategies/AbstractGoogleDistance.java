package ro.msg.learning.strategies;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import ro.msg.learning.entities.Address;
import ro.msg.learning.models.GoogleDistanceObject;
import ro.msg.learning.models.DistanceObject;

import java.util.List;


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
    public DistanceObject computeDistance(String shipAddress, List<Address> location) {
        DistanceObject distanceObject = new DistanceObject();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<GoogleDistanceObject> googleResponse = restTemplate.exchange(url, HttpMethod.GET, entity, GoogleDistanceObject.class, shipAddress + ",", location.get(0).getCity() + "," + location.get(0).getCountry(), apiKey);
        parseResponse(googleResponse.getBody());

        return distanceObject;
    }

}

