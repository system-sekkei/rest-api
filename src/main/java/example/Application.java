package example;

import com.fasterxml.jackson.databind.ObjectMapper;
import example.infrastructure.configuration.objectmapper.CustomObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public ObjectMapper directFieldAccess() {
        return new CustomObjectMapper().ofDirectFieldAccess();
    }
}