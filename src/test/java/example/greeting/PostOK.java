package example.greeting;

import example.BaseTest;
import example.presentation.view.greeting.GreetingRequest;
import example.specification.Attempt;
import example.specification.Expect;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.Arrays;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostOK extends BaseTest {

    @Test
    public void PostJsonFromFile() {

        String json = super.ofFile("greeting-request.json");

        given().log().all()
            .spec(Attempt.postJson(json))

        .when().post("/greeting")

        .then().log().all()
            .spec(Expect.status(HttpStatus.SC_OK))

            .body("content", stringContainsInOrder(Arrays.asList("Hello", "増田", "!")));
            // 文字列が指定した順番で出現する
    }

    @Test
    public void PostJsonFromObject() {

        GreetingRequest json = new GreetingRequest("増田");

        given().log().all()
            .spec(Attempt.postJson(json))

        .when().post("/greeting")

        .then().log().all()

            .spec(Expect.status(HttpStatus.SC_OK))

            .body("id", greaterThan(0))
            .body("id", lessThan(10)); // 数値の範囲
    }


}
