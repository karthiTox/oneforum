package com.karthitox.oneforum.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.karthitox.oneforum.exception.UserAlreadyExistException;
import com.karthitox.oneforum.model.Role;
import com.karthitox.oneforum.model.dto.AuthenticationRequestDTO;
import com.karthitox.oneforum.model.dto.AuthenticationResponseDTO;
import com.karthitox.oneforum.repository.AnswerRepository;
import com.karthitox.oneforum.repository.QuestionRepository;
import com.karthitox.oneforum.repository.TopicRepository;
import com.karthitox.oneforum.repository.UserRepository;
import com.karthitox.oneforum.repository.VoteRepository;
import com.karthitox.oneforum.service.AuthService;

@Component
public class AppHelper {

	@Autowired
	public AuthService authService;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public TopicRepository topicRepository;
	
	@Autowired
	public QuestionRepository questionRepository;
	
	@Autowired
	public AnswerRepository answerRepository;

	@Autowired
	public VoteRepository voteRepository;

	
	public AuthenticationResponseDTO initNewUser(String email) throws UserAlreadyExistException {
		AuthenticationRequestDTO authData = new AuthenticationRequestDTO();
		authData.setEmail(email);
		authData.setPassword(email);		
		return authService.registerUser(authData, Role.USER);
	}	
	
	public void clearWholeDB() {
		voteRepository.deleteAll();
		answerRepository.deleteAll();
		questionRepository.deleteAll();
		topicRepository.deleteAll();
		userRepository.deleteAll();
	}
	
	
}
