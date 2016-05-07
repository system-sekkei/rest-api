package example.presentation.view.greeting;

import example.domain.model.greeting.Greeting;

public class GreetingResponse {
    long id ;
    String content;

    public GreetingResponse(Greeting model) {
        id = model.id();
        content = model.content();
    }

    public GreetingResponse() {
        ;
    }

    @Override
    public String toString() {
        return "GreetingResponse{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
