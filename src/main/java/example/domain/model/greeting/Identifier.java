package example.domain.model.greeting;

public class Identifier {
    long value;

    public Identifier(long value) {
        this.value = value;
    }

    public Identifier() {
    }

    public String format() {
        return String.format("%d番目", value);
    }
}
