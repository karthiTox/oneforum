package com.karthitox.oneforum.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.karthitox.oneforum.model.serializer.AnswerSerializer;
import com.karthitox.oneforum.model.serializer.TopicSerializer;
import com.karthitox.oneforum.model.serializer.UserSerializer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(VoteId.class)
public class Vote {
	
	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "answerId", referencedColumnName = "aid")
	@JsonSerialize(using = AnswerSerializer.class)	
	private Answer answer;
	
	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "voterId", referencedColumnName = "uid")
	private User voter;
	
	public Vote() {}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public User getVoter() {
		return voter;
	}

	public void setVoter(User voter) {
		this.voter = voter;
	}
	
}
