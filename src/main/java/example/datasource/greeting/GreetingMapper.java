package example.datasource.greeting;

import example.model.greeting.Greeting;
import org.apache.ibatis.annotations.Param;

public interface GreetingMapper {
    void register(@Param("greeting") Greeting greeting);
}
