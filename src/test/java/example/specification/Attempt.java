package example.specification;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

public class Attempt {

    public static RequestSpecification postJson(Object body) {
        RequestSpecBuilder builder = new RequestSpecBuilder();

        builder.setContentType(ContentType.JSON);
        builder.setBody(body);

        RequestSpecification specification = builder.build();

        return specification;
    }

    public static RequestSpecification get(String parameterName, String parameterValue) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addParam(parameterName, parameterValue);

        RequestSpecification specification = builder.build();

        return specification;
    }
}
