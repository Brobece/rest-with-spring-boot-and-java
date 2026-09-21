package br.com.brobece;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import tools.jackson.core.JsonGenerator;

import java.io.IOException;

public class GenderSerializer extends JsonSerializer<String> {


    @Override
    public void serialize(String gender, com.fasterxml.jackson.core.JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String formatedGender = "Male".equals(gender) ? "M" : "F";
        gen.writeString(formatedGender);
    }
}
