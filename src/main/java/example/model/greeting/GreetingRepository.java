package example.model.greeting;

import java.util.List;

public interface GreetingRepository {
    void recordRequest(Greeting greeting);
    GreetingHistory history();
}
