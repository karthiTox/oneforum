package com.karthitox.oneforum.model.dto;

import java.util.UUID;

import lombok.ToString;

@ToString
public class AnswerCreationRequestDTO {
	private String content;
	private UUID questionId;

	public AnswerCreationRequestDTO() {
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UUID getQuestionId() {
		return questionId;
	}

	public void setQuestionId(UUID questionId) {
		this.questionId = questionId;
	}
	
	

}
