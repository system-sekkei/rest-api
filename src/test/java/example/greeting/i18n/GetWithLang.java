package example.greeting.i18n;

import example.BaseTest;
import example.specification.Attempt;
import example.specification.Expect;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetWithLang extends BaseTest {
    @Test
    public void en() {

        given().log().all()
                .spec(Attempt.get("name", "増田"))
                //.spec(Attempt.withValidKey())
                .queryParam("lang","en")

                .when().get("/greeting")

                .then().log().all()
                .spec(Expect.status(HttpStatus.SC_OK))

                .body("content", equalTo("Hello, 増田!")) //同じ文字列
        ;
    }

    @Test
    public void ja() {

        given().log().all()
                .spec(Attempt.get("name", "増田"))
                //.spec(Attempt.withValidKey())
                .queryParam("lang","ja")

        .when().get("/greeting")

        .then().log().all()
                .spec(Expect.status(HttpStatus.SC_OK))

                .body("content", equalTo("増田さん、こんにちは")) //同じ文字列
        ;
    }
}
