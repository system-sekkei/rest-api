package example.service;

import example.model.Greeting;
import example.model.GreetingFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    GreetingFactory factory;

    public Greeting greetTo(String name) {
        return factory.generate(name);
    }
}
