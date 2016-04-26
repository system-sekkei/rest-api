package example.viewmodel;

import example.model.Greeting;

public class GreetingResponse {
    public long id ;
    public String content;

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
