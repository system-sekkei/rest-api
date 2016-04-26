package example.model.greeting;

import javax.validation.constraints.NotNull;

public class Greeting {

    private Long id;
    private String greetTo;


    public Greeting(@NotNull Long id, @NotNull String greetTo) {
        this.id = id;
        this.greetTo = greetTo;
    }

    {
        id = -1L;
        greetTo = "";
    }
    public Greeting() {

    }

    public long id() {
        return id;
    }

    private static final String template = "Hello, %s!";
    public String content() {
        return String.format(template,greetTo);
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", greetTo='" + greetTo + '\'' +
                '}';
    }
}
