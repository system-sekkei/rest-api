package example.specification;


import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.specification.ResponseSpecification;

public class Expect {

    public static ResponseSpecification status(int statusCode) {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();

        builder.expectStatusCode(statusCode);

        ResponseSpecification specification = builder.build();

        return specification;

    }
}
