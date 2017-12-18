package ro.msg.learning.strategies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.dtos.OrderDTO;
import ro.msg.learning.dtos.OrderDetailsDTO;
import ro.msg.learning.entities.Address;
import ro.msg.learning.entities.Location;
import ro.msg.learning.entities.ProductLocationRelationship;
import ro.msg.learning.repositories.ProductLocationRelationshipRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class ProximityStrategy implements OrderStrategy {

    private final ProductLocationRelationshipRepository productLocationRelationshipRepository;
    private DistanceComputation distanceComputation;

    @Autowired
    public ProximityStrategy(ProductLocationRelationshipRepository productLocationRelationshipRepository, DistanceComputation distanceComputation) {
        this.productLocationRelationshipRepository = productLocationRelationshipRepository;
        this.distanceComputation = distanceComputation;
    }

    @Override
    public Set<ProductLocationRelationship> handleOrders(OrderDTO orderdto) {
        List<Address> addresses = new ArrayList<>();
        List<Long> products = new ArrayList<>();
        Set<ProductLocationRelationship> productLocationRelationships = new HashSet<>();
        for(OrderDetailsDTO product : orderdto.getOrderDetailsProducts()){
            products.add(product.getProduct().getProductId());
        }
        Set<Location> locations = productLocationRelationshipRepository.loadAllLocations(products);

        for(Location location : locations){
            Address cityCountry = new Address();
            cityCountry.setCity(location.getAddress().getCity());
            cityCountry.setCountry(location.getAddress().getCountry());
            addresses.add(cityCountry);
        }

        distanceComputation.computeDistance(orderdto.getShipAddress(), addresses);

        return productLocationRelationships;
    }
}
