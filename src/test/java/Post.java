import com.jayway.restassured.http.ContentType;
import example.viewmodel.GreetingRequest;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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
        body("content", equalTo("Hello, masuda!"));
    }

    @Test
    public void PostJsonFromFile() {

        String json = super.ofFile("test.json");

        given().log().all().
                contentType(ContentType.JSON).
                body(json).
        when().post("/greeting/object").
        then().log().all().
                statusCode(HttpStatus.SC_OK).
                body("content", equalTo("Hello, 増田!"));
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
                body("content", equalTo("Hello, 増田!"));
    }
}
