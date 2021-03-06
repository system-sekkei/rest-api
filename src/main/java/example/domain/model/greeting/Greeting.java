package example.domain.model.greeting;

import example.infrastructure.configuration.messagesource.MessageResolver;

import javax.validation.constraints.NotNull;

public class Greeting {

    private Identifier id;
    private String greetTo;


    public Greeting(@NotNull Identifier id, @NotNull String greetTo) {
        this.id = id;
        this.greetTo = greetTo;
    }

    public Greeting() {

    }

    public Identifier id() {
        return id;
    }

    public String content() {
        return MessageResolver.of("example.greeting.hello",greetTo);
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", greetTo='" + greetTo + '\'' +
                '}';
    }
}
