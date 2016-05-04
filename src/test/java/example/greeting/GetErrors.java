package example.greeting;

import example.BaseTest;
import example.specification.Attempt;
import example.specification.Expect;
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class GetErrors extends BaseTest {
    @Test
    public void withoutName() {
        given().log().all()
            // パラメータを指定しない

        .when().get("/greeting")

        .then().log().all()
            .spec(Expect.status(HttpStatus.SC_BAD_REQUEST))

            .body("errors[0].message", CoreMatchers.endsWith("may not be empty"))
        ;
    }

    @Test
    public void withBlankName() {
        given().log().all()
            .spec(Attempt.get("name", ""))

        .when().get("/greeting")

        .then().log().all()
            .spec(Expect.status(HttpStatus.SC_BAD_REQUEST))
        ;
    }
}
