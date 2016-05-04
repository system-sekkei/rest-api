package example.presentation.view.greeting;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class GreetingRequest {

    @NotBlank
    @Size(min=2)
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
