package example.datasource.greeting;

import example.model.greeting.Greeting;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GreetingMapper {
    void register(@Param("greeting") Greeting greeting);
    List<Greeting> list();
}
