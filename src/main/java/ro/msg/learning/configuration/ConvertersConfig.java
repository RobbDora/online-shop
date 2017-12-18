package ro.msg.learning.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import ro.msg.learning.converters.CsvHttpMessageConverter;

@Configuration
public class ConvertersConfig {

    @Bean
    public HttpMessageConverter extendMessageConverters () {
        return new CsvHttpMessageConverter();
    }

}
