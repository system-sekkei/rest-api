package example.datasource.greeting;

import example.model.greeting.Greeting;
import example.model.greeting.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GreetingDatasource implements GreetingRepository{

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    GreetingMapper mapper;

    @Override
    public void recordRequest(Greeting greeting) {
        mapper.register(greeting);
    }

    @Override
    public List<Greeting> list() {
        return mapper.list();
    }

}
