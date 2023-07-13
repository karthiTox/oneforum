package com.karthitox.oneforum.service;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
public class AnswerServiceTest {

	@Autowired
	QuestionService questionService;
	
	@Autowired
	AnswerService answerServiceUnderTest;

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

	@BeforeAll
	static void beforeAll(
			@Autowired AppHelper appHelper,
			@Autowired QuestionService questionService,
			@Autowired AnswerService answerService
	) throws UserAlreadyExistException, UserNotFoundException, TopicNotFoundException, QuestionNotFoundException {
		appHelper.clearWholeDB();
		
		user1 = appHelper.initNewUser("test1@test.com").getUser();
		user2 = appHelper.initNewUser("test2@test.com").getUser();
		user3 = appHelper.initNewUser("test3@test.com").getUser();
		
		String content = "this is test content";
		String topic = "test";

		mainQuestion = questionService.createQuestion(content, user1.getEmail(), topic);
		
		for (int i = 0; i < 10; i++) {
			answerService.addAnswer(user1.getEmail(), mainQuestion.getQid(), content);			
			answerService.addAnswer(user2.getEmail(), mainQuestion.getQid(), content);
			answerService.addAnswer(user3.getEmail(), mainQuestion.getQid(), content);
		}
	}

	@AfterAll
	static void afterAll(@Autowired AppHelper appHelper) {
		appHelper.clearWholeDB();
	}
	
	@Test
	void new_answers_should_be_created() throws UserNotFoundException, TopicNotFoundException, QuestionNotFoundException {		
		assertThat(answerRepository.count()).isEqualTo(30);	
	}

	@Test
	void testing_custom_queries_of_answer() {
		// Assertion
		for(Answer answer: answerServiceUnderTest.fetchAllAnswersOfQuestion(mainQuestion.getQid())) {
			assertThat(answer.getQuestion().getQid()).isEqualTo(mainQuestion.getQid());
		}

		assertThat(answerServiceUnderTest.countAllAnswersOfQuestion(mainQuestion.getQid())).isEqualTo(30);

		int size = 2;
		for (int i = 0; i < 10/size; i++) {
			for(Answer answer: answerServiceUnderTest.fetchPagedAnswersOfQuestion(mainQuestion.getQid(), i, size)) {
				assertThat(answer.getQuestion().getQid()).isEqualTo(mainQuestion.getQid());
			}
		}
	}
}
