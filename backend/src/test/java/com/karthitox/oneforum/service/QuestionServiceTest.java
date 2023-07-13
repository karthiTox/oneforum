package com.karthitox.oneforum.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.karthitox.oneforum.exception.TopicNotFoundException;
import com.karthitox.oneforum.exception.UserAlreadyExistException;
import com.karthitox.oneforum.exception.UserNotFoundException;
import com.karthitox.oneforum.helper.AppHelper;
import com.karthitox.oneforum.model.Question;
import com.karthitox.oneforum.model.User;
import com.karthitox.oneforum.repository.QuestionRepository;
import com.karthitox.oneforum.repository.TopicRepository;



@SpringBootTest
public class QuestionServiceTest {

	@Autowired
	QuestionService questionServiceUnderTest;

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	TopicRepository topicRepository;

	static User user1;
	static User user2;
	static User user3;

	@BeforeAll
	static void beforeAll(@Autowired AppHelper appHelper) throws UserAlreadyExistException {
		appHelper.clearWholeDB();
		
		user1 = appHelper.initNewUser("test1@test.com").getUser();
		user2 = appHelper.initNewUser("test2@test.com").getUser();
		user3 = appHelper.initNewUser("test3@test.com").getUser();
	}

	@AfterAll
	static void afterAll(@Autowired AppHelper appHelper) {
		appHelper.clearWholeDB();
	}

	@Test
	void only_one_topic_of_same_name_should_be_created() {
		questionServiceUnderTest.createTopic("testing");
		questionServiceUnderTest.createTopic("testing2");
		questionServiceUnderTest.createTopic("testing");
		questionServiceUnderTest.createTopic("testing");
		questionServiceUnderTest.createTopic("testing2");

		// Assertion
		assertThat(topicRepository.count()).isEqualTo(2);

		topicRepository.deleteAll();
	}

	@Test
	void new_question_should_be_created() throws UserNotFoundException, TopicNotFoundException {
		String content = "this is test content";
		String topic = "test";

		questionServiceUnderTest.createQuestion(content, user1.getEmail(), topic);

		// Assertion
		assertThat(questionRepository.count()).isEqualTo(1);
		assertThat(questionRepository.findAll().get(0).getContent()).isEqualTo(content);
		assertThat(questionRepository.findAll().get(0).getTopic().getTopicName()).isEqualTo(topic);

		questionRepository.deleteAll();
		topicRepository.deleteAll();
	}

	@Test
	void testing_find_all_queries_by_topic() throws UserNotFoundException, TopicNotFoundException {
		String content = "this is test content";
		String topic1 = "test1";
		String topic2 = "test2";

		for (int i = 0; i < 10; i++) {
			questionServiceUnderTest.createQuestion(content, user1.getEmail(), topic1);
			questionServiceUnderTest.createQuestion(content, user2.getEmail(), topic2);
		}

		// Assertion
		for(Question question: questionServiceUnderTest.fetchAllQuestionOfTopic(topic1)) {
			assertThat(question.getTopic().getTopicName()).isEqualTo(topic1);
		}
		assertThat(questionServiceUnderTest.countAllQuestionsByTopicName(topic2)).isEqualTo(10);

		int size = 2;

		for (int i = 0; i < 10/size; i++) {
			for(Question question: questionServiceUnderTest.fetchPagedQuestionOfTopic(topic1, i, size)) {
				assertThat(question.getTopic().getTopicName()).isEqualTo(topic1);
			}
		}


		questionRepository.deleteAll();
		topicRepository.deleteAll();
	}

	@Test
	void testing_find_all_queries_by_user() throws UserNotFoundException, TopicNotFoundException {
		String content = "this is test content";
		String topic1 = "test1";
		String topic2 = "test2";

		for (int i = 0; i < 10; i++) {
			questionServiceUnderTest.createQuestion(content, user1.getEmail(), topic1);
			questionServiceUnderTest.createQuestion(content, user2.getEmail(), topic2);
		}

		// Assertion
		for(Question question: questionServiceUnderTest.fetchAllQuestionOfUserId(user1.getUid())) {
			assertThat(question.getOwner().getUid()).isEqualTo(user1.getUid());
		}
		assertThat(questionServiceUnderTest.countAllQuestionsByUserId(user2.getUid())).isEqualTo(10);

		int size = 2;

		for (int i = 0; i < 10/size; i++) {
			for(Question question: questionServiceUnderTest.fetchPagedQuestionOfUserId(user1.getUid(), i, size)) {
				assertThat(question.getOwner().getUid()).isEqualTo(user1.getUid());
			}
		}


		questionRepository.deleteAll();
		topicRepository.deleteAll();
	}

}
