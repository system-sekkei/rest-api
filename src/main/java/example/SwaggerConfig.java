package example;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("greetings")
                .apiInfo(apiInfo())
                .select()
                .paths(patterns())
                .build();
    }

    private Predicate<String> patterns() {
        return or(
                regex("/greeting.*"),
                regex("/anotherPathPattern") //ダミー
        );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API ドキュメント by Swagger2")
                .description("Spring REST Sample with Swagger")
                .build();
    }

}
