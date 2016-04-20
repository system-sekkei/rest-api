package example.datasource;

import example.model.Greeting;
import example.model.GreetingFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class InMemoryGreetingFactory implements GreetingFactory {

    private static final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting generate(String greetTo) {
        return new Greeting( counter.incrementAndGet(),greetTo);
    }
}
