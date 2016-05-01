package example.application.service;

import example.domain.model.greeting.Greeting;
import example.domain.model.greeting.GreetingFactory;
import example.domain.model.greeting.GreetingHistory;
import example.domain.model.greeting.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    GreetingFactory factory;

    @Autowired
    GreetingRepository repository;

    public Greeting generate(String name) {
        return factory.generate(name);
    }

    public void recordRequest(Greeting greeting) {
        repository.recordRequest(greeting);
    }

    public GreetingHistory history() {
        return repository.history();
    }

}
