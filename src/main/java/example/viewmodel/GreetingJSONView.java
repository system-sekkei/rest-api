package example.viewmodel;

import example.model.Greeting;

public class GreetingJSONView {
    public long id ;
    public String content;

    public GreetingJSONView(Greeting model) {
        id = model.id();
        content = model.content();
    }

    public GreetingJSONView() {
        ;
    }

    @Override
    public String toString() {
        return "GreetingJSONView{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
