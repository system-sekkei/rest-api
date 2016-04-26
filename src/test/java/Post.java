import org.apache.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Post extends BaseForAll {

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
