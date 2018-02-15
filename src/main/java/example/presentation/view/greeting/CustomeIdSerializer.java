package example.presentation.view.greeting;

import example.domain.model.greeting.Identifier;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CustomeIdSerializer extends JsonSerializer<Identifier> {

    @Override
    public void serialize(
            Identifier value,
            JsonGenerator generator,
            SerializerProvider serializers) throws IOException, JsonProcessingException {
        generator.writeString(value.format());
    }
}
