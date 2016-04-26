package example.model.user;

public class UserSummary {
    UserIdentifier identifier;
    Name name;

    public UserIdentifier identifier() {
        return identifier;
    }

    public Name name() {
        return name;
    }

    @Override
    public String toString() {
        return "UserSummary{" +
                "identifier=" + identifier +
                ", name=" + name +
                '}';
    }
}
