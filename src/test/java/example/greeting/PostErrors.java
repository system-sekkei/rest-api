package example.greeting;

import example.BaseTest;
import example.presentation.view.greeting.GreetingRequest;
import example.specification.Attempt;
import example.specification.Expect;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class PostErrors extends BaseTest {

    @Test
    public void withBlankName() {

        GreetingRequest json = new GreetingRequest("");

        given().log().all()
            .spec(Attempt.postJson(json))

        .when().post("/greeting")

        .then().log().all()
            .spec(Expect.status(HttpStatus.SC_BAD_REQUEST))
        ;
    }

    @Test
    public void withTooShortName() {
        GreetingRequest json = new GreetingRequest("x");
        given().log().all()
            .spec(Attempt.postJson(json))

        .when().post("/greeting")

        .then().log().all()
            .spec(Expect.status(HttpStatus.SC_BAD_REQUEST))
        ;

    }
}
