package integration;

import org.apache.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Masuda on 2016/04/25.
 */
public class SubTest extends BaseTest{

    @Test
    public void SimplePOST() {
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
