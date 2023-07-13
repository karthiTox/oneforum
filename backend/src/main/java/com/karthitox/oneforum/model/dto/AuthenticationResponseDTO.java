package com.karthitox.oneforum.model.dto;

import com.karthitox.oneforum.model.User;

public class AuthenticationResponseDTO {
	private User user;
	private String token;

	public AuthenticationResponseDTO() {
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
