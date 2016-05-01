package example.infrastructure.datasource.greeting;

import example.domain.model.greeting.Greeting;
import example.domain.model.greeting.GreetingFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SequenceBaseGreetingFactory implements GreetingFactory{

    @Autowired
    GreetingMapper mapper;

    @Override
    public Greeting generate(String greetTo) {
        return new Greeting(mapper.generateRequestId(), greetTo);
    }
}