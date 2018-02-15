package example.presentation.view.greeting;

import example.domain.model.greeting.Greeting;
import example.domain.model.greeting.Identifier;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class GreetingResponse {
    @JsonSerialize(using = CustomeIdSerializer.class)
    Identifier id ;
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
