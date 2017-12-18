package ro.msg.learning.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import ro.msg.learning.strategies.AbstractGoogleDistance;
import ro.msg.learning.strategies.DistanceComputation;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Configuration
@PropertySource(value = "classpath:application-secret.properties")
public class DistanceConfig {

    @Value("${google.apiKey}")
    private String apiKey;

    @Value("${secret.proxy.host}")
    private String host;

    @Value("${secret.proxy.port}")
    private String port;

    @Value("${secret.url}")
    private String url;

    @Bean
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        Proxy proxy= new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, Integer.parseInt(port)));
        requestFactory.setProxy(proxy);
        return new RestTemplate(requestFactory);
    }

    @Bean
    public DistanceComputation getDistance(){
        return new AbstractGoogleDistance(url, apiKey, restTemplate());
    }

}
