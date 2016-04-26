import org.apache.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get extends BaseForAll {
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
}
