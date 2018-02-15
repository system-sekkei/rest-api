package example.infrastructure.configuration.objectmapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.fasterxml.jackson.annotation.PropertyAccessor.*;

public class CustomObjectMapper {
    public ObjectMapper ofDirectFieldAccess() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.setVisibility(GETTER, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(SETTER, JsonAutoDetect.Visibility.NONE);
        return mapper;
    }
}
