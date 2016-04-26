import org.apache.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get extends BaseForAll {
    @Test
    public void GETwithParams() {
        given().
                log().all().
                param("name", "増田").
        when().
                get("/greeting/params").
        then().
                log().all().
                statusCode(HttpStatus.SC_OK).
                body("content", equalTo("Hello, 増田!"))
        ;
    }
}
