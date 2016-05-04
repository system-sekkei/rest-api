package example.presentation.view.greeting;

public class GreetingRequest {
    public String name ;

    public GreetingRequest(String name) {
        this.name = name;
    }

    public GreetingRequest() {

    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "GreetingRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
