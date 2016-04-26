package example.model.greeting;

import javax.validation.constraints.NotNull;

public class Greeting {

    private final Long id;
    private final String greetTo;


    public Greeting(@NotNull Long id, @NotNull String greetTo) {
        this.id = id;
        this.greetTo = greetTo;
    }

    public long id() {
        return id;
    }

    private static final String template = "Hello, %s!";
    public String content() {
        return String.format(template,greetTo);
    }
}
