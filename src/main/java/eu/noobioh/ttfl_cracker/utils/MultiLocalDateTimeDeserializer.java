package eu.noobioh.ttfl_cracker.utils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class MultiLocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {
	private static final long serialVersionUID = 1L;
	
	private static final String[] DATE_FORMATS = new String[] {
		"yyyy-MM-dd HH:mm:ss VV",
        "yyyy-MM-dd'T'HH:mm:ss.AAAVV"
    };

    public MultiLocalDateTimeDeserializer() {
        this(null);
    }

    public MultiLocalDateTimeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        final String date = node.textValue();

        for (String DATE_FORMAT : DATE_FORMATS) {
            try {
                return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT));
            } catch (DateTimeParseException e) {
            }
        }
        throw new JsonParseException(jp, "Unparseable date: \"" + date + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
    }
}
