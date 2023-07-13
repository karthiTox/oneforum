package com.karthitox.oneforum.model.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.karthitox.oneforum.model.Question;
import com.karthitox.oneforum.model.User;

/**
 * serialize the object into it's respective Id string, when parsing
 */
public class QuestionSerializer extends StdSerializer<Question> {

	public QuestionSerializer() {
		this(null);
	}

	public QuestionSerializer(Class<Question> t) {
		super(t);
	}

	@Override
	public void serialize(Question value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		jgen.writeString(value.getQid().toString());
	}

}
