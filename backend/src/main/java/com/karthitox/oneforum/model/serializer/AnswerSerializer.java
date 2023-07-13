package com.karthitox.oneforum.model.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.karthitox.oneforum.model.Answer;
import com.karthitox.oneforum.model.Question;
import com.karthitox.oneforum.model.User;

/**
 * serialize the object into it's respective Id string, when parsing
 */
public class AnswerSerializer extends StdSerializer<Answer> {

	public AnswerSerializer() {
		this(null);
	}

	public AnswerSerializer(Class<Answer> t) {
		super(t);
	}

	@Override
	public void serialize(Answer value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		jgen.writeString(value.getAid().toString());
	}

}
