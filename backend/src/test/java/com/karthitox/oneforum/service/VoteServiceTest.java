package com.karthitox.oneforum.service;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.karthitox.oneforum.exception.AnswerNotFoundException;
import com.karthitox.oneforum.exception.QuestionNotFoundException;
import com.karthitox.oneforum.exception.TopicNotFoundException;
import com.karthitox.oneforum.exception.UserAlreadyExistException;
import com.karthitox.oneforum.exception.UserNotFoundException;
import com.karthitox.oneforum.helper.AppHelper;
import com.karthitox.oneforum.model.Answer;
import com.karthitox.oneforum.model.Question;
import com.karthitox.oneforum.model.User;
import com.karthitox.oneforum.repository.AnswerRepository;
import com.karthitox.oneforum.repository.QuestionRepository;
import com.karthitox.oneforum.repository.TopicRepository;



@SpringBootTest
public class VoteServiceTest {

	@Autowired
	QuestionService questionService;
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	VoteService voteService;

	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	AnswerRepository answerRepository;

	@Autowired
	TopicRepository topicRepository;

	static User user1;
	static User user2;
	static User user3;
	
	static Question mainQuestion;
	
	static Answer answer1;
	static Answer answer2;
	static Answer answer3;

	@BeforeAll
	static void beforeAll(
			@Autowired AppHelper appHelper,
			@Autowired QuestionService questionService,
			@Autowired AnswerService answerService,
			@Autowired VoteService voteService
	) throws UserAlreadyExistException, UserNotFoundException, TopicNotFoundException, QuestionNotFoundException, AnswerNotFoundException {
		appHelper.clearWholeDB();
		
		user1 = appHelper.initNewUser("test1@test.com").getUser();
		user2 = appHelper.initNewUser("test2@test.com").getUser();
		user3 = appHelper.initNewUser("test3@test.com").getUser();
		
		String content = "this is test content";
		String topic = "test";

		mainQuestion = questionService.createQuestion(content, user1.getEmail(), topic);
		
		answer1 = answerService.addAnswer(user1.getEmail(), mainQuestion.getQid(), content);			
		answer2 = answerService.addAnswer(user2.getEmail(), mainQuestion.getQid(), content);
		answer3 = answerService.addAnswer(user3.getEmail(), mainQuestion.getQid(), content);

		voteService.addVote(user1.getEmail(), answer1.getAid());
	}

	@AfterAll
	static void afterAll(@Autowired AppHelper appHelper) {
		appHelper.clearWholeDB();
	}
	
	@Test
	void user_should_not_multiple_votes() throws UserNotFoundException, AnswerNotFoundException {				
		voteService.addVote(user2.getEmail(), answer2.getAid());
		voteService.addVote(user2.getEmail(), answer2.getAid());
		
		voteService.addVote(user3.getEmail(), answer2.getAid());
		voteService.addVote(user3.getEmail(), answer2.getAid());
		
		assertThat(voteService.countAllVotesForAnswer(answer2.getAid())).isEqualTo(2);
	}
	
	@Test
	void user_should_able_to_delete_votes() throws UserNotFoundException, AnswerNotFoundException {				
		voteService.addVote(user2.getEmail(), answer2.getAid());
		voteService.addVote(user3.getEmail(), answer2.getAid());
		
		voteService.deleteVote(user2.getEmail(), answer2.getAid());
		voteService.deleteVote(user3.getEmail(), answer2.getAid());
		
		assertThat(voteService.countAllVotesForAnswer(answer2.getAid())).isEqualTo(0);
	}
}
