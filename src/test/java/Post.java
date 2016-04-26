import com.jayway.restassured.http.ContentType;
import example.viewmodel.GreetingRequest;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.Arrays;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Post extends BaseForAll {

    @Test
    public void PostWithParam() {
        given() .
        log().all().
        param("name", "masuda").
        when().
        post("/greeting/params").
        then().
        log().all().
        statusCode(HttpStatus.SC_OK).
        body("content", equalTo("Hello, masuda!")); // 同じ文字列
    }

    @Test
    public void PostJsonFromFile() {

        String json = super.ofFile("greeting-request.json");

        given().log().all().
                contentType(ContentType.JSON).
                body(json).
        when().post("/greeting/object").
        then().log().all().
                statusCode(HttpStatus.SC_OK).
                body("content", stringContainsInOrder(Arrays.asList("Hello","増田", "!")));
        // 文字列が指定した順番で出現する
    }

    @Test
    public void PostJsonFromObject() {

        GreetingRequest json = new GreetingRequest("増田");
        given().log().all().
                contentType(ContentType.JSON).
                body(json).
                when().post("/greeting/object").
                then().log().all().
                statusCode(HttpStatus.SC_OK).
                body("id", greaterThan(0)).
                body("id", lessThan(10)); // 数値の範囲
    }
}
