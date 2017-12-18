package ro.msg.learning.configuration;

import ro.msg.learning.strategies.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.repositories.ProductLocationRelationshipRepository;
import ro.msg.learning.strategies.types.StrategyType;

@Configuration
public class GlobalConfig {

    private final ProductLocationRelationshipRepository productLocationRelationshipRepository;
    private final DistanceComputation distanceComputation;

    @Value("${onlineshop.strategy.type}")
    private StrategyType strategyType;

    public GlobalConfig(ProductLocationRelationshipRepository productLocationRelationshipRepository, DistanceComputation distanceComputation) {
        this.productLocationRelationshipRepository = productLocationRelationshipRepository;
        this.distanceComputation = distanceComputation;
    }

    @Bean
    public OrderStrategy getStrategyType(){
        switch(strategyType){
            case SINGLE:
                return new SingleLocationStrategy(productLocationRelationshipRepository);
            case ABUNDANT:
                return new AbundantLocationStrategy(productLocationRelationshipRepository);
            case GREEDY:
                return new GreedyStrategy(productLocationRelationshipRepository);
            case PROXIMITY:
                return new ProximityStrategy(productLocationRelationshipRepository, distanceComputation);
        }
        throw new IllegalArgumentException();
    }
}
