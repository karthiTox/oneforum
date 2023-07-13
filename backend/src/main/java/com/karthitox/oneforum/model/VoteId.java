package com.karthitox.oneforum.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;

class VoteId implements Serializable {
	private Answer answer;
	private User voter;
	
	public VoteId() {}
	
	public VoteId(
			Answer answer,
			User voter
	) {
		this.answer = answer;
		this.voter = voter;
	}
}