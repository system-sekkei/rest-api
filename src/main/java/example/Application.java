package example;

import com.fasterxml.jackson.databind.ObjectMapper;
import example.infrastructure.configuration.objectmapper.CustomObjectMapper;
import example.presentation.view.errors.CustomErrorAttributes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
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

    @Bean
    public ErrorAttributes errorAttributes() {
        return new CustomErrorAttributes();
    }

}