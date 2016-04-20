package テスト;

import example.Application;
import com.jayway.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class 結合テスト {

    //Test RestTemplate to invoke the APIs.
    private RestTemplate restTemplate = new TestRestTemplate();

    @Value("${server.port}")
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port; // http://localhost:PORT を使う
    }


    @Test
    public void 単純なGET() {
            given().
                log().all().
                param("name", "masuda").
            when().
                get("/greeting").
            then().
                log().all().
                statusCode(HttpStatus.SC_OK).
                body("content", equalTo("Hello, masuda!"))
            ;
    }

    @Test
    public void 単純なPOST() {
        given().
                log().all().
                param("name", "masuda").
        when().
                post("/greeting").
        then().
                log().all().
                statusCode(HttpStatus.SC_OK).
                body("content", equalTo("Hello, masuda!"));

    }
}
