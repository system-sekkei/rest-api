package example.domain.model.greeting;

public interface GreetingRepository {
    void recordRequest(Greeting greeting);
    GreetingHistory history();
}
