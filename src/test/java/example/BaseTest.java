package example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.ObjectMapperConfig;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.mapper.factory.Jackson2ObjectMapperFactory;
import example.Application;
import example.infrastructure.configuration.objectmapper.CustomObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//FIXME テストクラスのスキャン、ポートの設定
//BaseTestの拡張というアプローチが良くない？
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
        "management.port=0", "management.context-path=/admin" })
@DirtiesContext

//TODO 旧バージョン 削除する
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@WebIntegrationTest
abstract public class BaseTest {
    @Value("${server.port}")
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port; // http://localhost:PORT を使う
    }

    @Before
    public void customObjectMapper() {
        RestAssured.config = RestAssuredConfig.config()
                .objectMapperConfig(new ObjectMapperConfig().jackson2ObjectMapperFactory(
                        new Jackson2ObjectMapperFactory() {
                            @Override
                            public ObjectMapper create(Class aClass, String s) {
                                return new CustomObjectMapper().ofDirectFieldAccess();
                            }
                        }
                        )
                );
    }

    /*
     rest-assured:2.9.0 のバグ対応
      body( File file ) が正常に動作しない、 body(String content) を使用する
     */
    public String ofFile(String filename ) {
        Path path = getPath(filename);

        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StringBuilder result = new StringBuilder();
        for( String line : lines) {
            result.append(line);
        }

        return result.toString();
    }

    private Path getPath(String filename) {

        String target = "data/" + filename;

        Resource resource = new ClassPathResource(target);

        try {
            return Paths.get(resource.getURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
