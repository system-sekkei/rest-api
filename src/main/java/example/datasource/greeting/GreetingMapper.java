package example.datasource.greeting;

import example.model.greeting.Greeting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GreetingMapper {
    void register(@Param("greeting") Greeting greeting);
    List<Greeting> list();

    @Select("select nextval('greeting.request_id')")
    long generateRequestId();
}
