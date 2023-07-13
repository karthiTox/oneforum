package com.karthitox.oneforum.model.dto;

public class QuestionCreationRequestDTO {
	private String content;
	private String topicName;

	public QuestionCreationRequestDTO() {
	}

	public QuestionCreationRequestDTO(String content, String topicName) {
		super();
		this.content = content;
		this.topicName = topicName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	@Override
	public String toString() {
		return "PostCreationRequest [content=" + content + ", topicName=" + topicName + "]";
	}
	
	

}
