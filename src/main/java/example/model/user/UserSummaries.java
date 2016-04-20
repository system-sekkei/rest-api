package example.model.user;

import java.util.Collections;
import java.util.List;

/**
 * Created by haljik on 15/06/04.
 */
public class UserSummaries {
    final List<UserSummary> values;

    public UserSummaries(List<UserSummary> values) {
        this.values = values;
    }

    public List<UserSummary> list() {
        return Collections.unmodifiableList(values);
    }

}
