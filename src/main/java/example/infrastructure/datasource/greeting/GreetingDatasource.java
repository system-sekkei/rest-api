package example.infrastructure.datasource.greeting;

import example.domain.model.greeting.Greeting;
import example.domain.model.greeting.GreetingHistory;
import example.domain.model.greeting.GreetingRepository;
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
    public GreetingHistory history() {
        List<Greeting> list = mapper.list();
        return new GreetingHistory(list);
    }

}
