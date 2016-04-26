package integration;

import com.jayway.restassured.RestAssured;
import example.Application;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class BaseTest {
    @Value("${server.port}")
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port; // http://localhost:PORT を使う
    }
}
