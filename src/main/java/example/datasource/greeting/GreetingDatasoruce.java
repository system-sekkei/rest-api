package example.datasource.greeting;

import example.model.greeting.Greeting;
import example.model.greeting.GreetingRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GreetingDatasoruce implements GreetingRepository{

    @Override
    public void recordRequest(Greeting greeting) {
        ;
    }
}
