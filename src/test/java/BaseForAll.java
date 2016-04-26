import com.jayway.restassured.RestAssured;
import example.Application;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
abstract public class BaseForAll {
    @Value("${server.port}")
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port; // http://localhost:PORT を使う
    }

    /*
     rest-assured:2.9.0 のバグ対応
      body( File file ) が正常に動作しない、 body(String content) を使用する
     */
    public String ofFile(String filename ) {
        Path path = Paths.get("src","test","resources","data",filename);

        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StringBuilder result = new StringBuilder();
        for( String line : lines) {
            result.append(line);
        }

        return result.toString();
    }
}
