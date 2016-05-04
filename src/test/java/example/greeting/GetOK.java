package example.greeting;

import example.BaseTest;
import example.specification.Attempt;
import example.specification.Expect;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetOK extends BaseTest {
    @Test
    public void GetWithName() {

        given().log().all()
            .spec(Attempt.get("name", "増田"))

        .when().get("/greeting")

        .then().log().all()
            .spec(Expect.status(HttpStatus.SC_OK))

            .body("content", equalTo("Hello, 増田!")) //同じ文字列
        ;
    }

    @Test
    public void history() {

        given().log().all()

        .when().get("/greeting/history")

        .then().log().all()
            .spec(Expect.status(HttpStatus.SC_OK))
        ;
    }
}
