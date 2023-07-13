package com.karthitox.oneforum.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.karthitox.oneforum.exception.AnswerNotFoundException;
import com.karthitox.oneforum.exception.QuestionNotFoundException;
import com.karthitox.oneforum.exception.UserNotFoundException;
import com.karthitox.oneforum.model.*;
import com.karthitox.oneforum.repository.*;

@Service
public class AnswerService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private QuestionRepository postRepository;
	@Autowired
	private AnswerRepository answerRepository;
	
	public Answer addAnswer(String email, UUID questionId, String content) throws UserNotFoundException, QuestionNotFoundException {
		Optional<User> owner = userRepository.findByEmail(email);
		Optional<Question> question = postRepository.findById(questionId);

		if(owner.isEmpty()) {
			log.error("User not found while creating answer");			
			throw new UserNotFoundException("owner is need to create answer or post answer");
		}
		
		if(question.isEmpty()) {
			log.error("question not found while creating question");			
			throw new QuestionNotFoundException("parent question is not found while creating answer");
		}

		Answer answer = new Answer();		
		answer.setContent(content);
		answer.setOwner(owner.get());
		answer.setQuestion(question.get());
		
		return answerRepository.save(answer);
	}
	
	public void deleteAnswer(UUID aid, String email) throws UserNotFoundException, AnswerNotFoundException {
		Answer answer = answerRepository.findById(aid).orElseThrow(() -> new AnswerNotFoundException());
		User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());
		
		if (answer.getOwner().getUid() == user.getUid()) {
			answerRepository.deleteById(aid);
		}

	}
	

	public List<Answer> fetchAllAnswersOfQuestion(UUID questionId) {		
		return answerRepository.findAllAnswersOfQuestion(questionId);
	}
	
	public List<Answer> fetchPagedAnswersOfQuestion(UUID questionId, int pageNo, int size) {		
		return answerRepository.findPagedAnswersOfQuestion(questionId, PageRequest.of(pageNo, size)).toList();
	}
	
	public long countAllAnswersOfQuestion(UUID questionId) {		
		return answerRepository.countAllAnswersOfQuestion(questionId);
	}

	
}
