package example.domain.model.greeting;

import java.util.List;

public class GreetingHistory {
    List<Greeting> history ;

    public GreetingHistory(List<Greeting> list) {
        history = list;
    }

    public List<Greeting> asList() {
        return history;
    }
}
