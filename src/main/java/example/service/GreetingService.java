package example.service;

import example.model.greeting.Greeting;
import example.model.greeting.GreetingFactory;
import example.model.greeting.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    GreetingFactory factory;

    @Autowired
    GreetingRepository repository;

    public Greeting greetTo(String name) {
        return factory.generate(name);
    }

    public void recordRequest(Greeting greeting) {
        repository.recordRequest(greeting);
    }

    public List<Greeting> list() {
        return repository.list();
    }

}
