import org.apache.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class History extends BaseForAll{

    @Test
    public void getAll() {
        given().
                log().all().
                when().
                get("/list/all").
                then().
                log().all().
                statusCode(HttpStatus.SC_OK)
        ;
    }
}
