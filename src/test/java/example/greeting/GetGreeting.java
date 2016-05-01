package example.greeting;

import example.BaseForAll;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetGreeting extends BaseForAll {
    @Test
    public void GETwithName() {
        given().
            log().all().
            param("name", "増田").
        when().
            get("/greeting").
        then().
            log().all().
            statusCode(HttpStatus.SC_OK).
            body("content", equalTo("Hello, 増田!")) //同じ文字列
        ;
    }
}
