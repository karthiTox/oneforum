package com.karthitox.oneforum.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthitox.oneforum.exception.QuestionNotFoundException;
import com.karthitox.oneforum.exception.TopicNotFoundException;
import com.karthitox.oneforum.exception.UserNotFoundException;
import com.karthitox.oneforum.model.Question;
import com.karthitox.oneforum.model.dto.QuestionCreationRequestDTO;
import com.karthitox.oneforum.service.QuestionService;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@PostMapping()
	public ResponseEntity<Question> createQuestion(Authentication authentication,
			@RequestBody QuestionCreationRequestDTO questionCreationRequest)
			throws UserNotFoundException, TopicNotFoundException {
		String questionContent = questionCreationRequest.getContent();
		String email = authentication.getName();
		String topicName = questionCreationRequest.getTopicName();

		Question createdQuestion = questionService.createQuestion(questionContent, email, topicName);

		return ResponseEntity.ok(createdQuestion);
	}
	
	@GetMapping("/{qid}")
	public ResponseEntity<Question> getQuestion(@PathVariable("qid") UUID qid) throws QuestionNotFoundException {
		return ResponseEntity.ok(questionService.fetchQuestionById(qid));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return ResponseEntity.ok(questionService.fetchAllQuestions());
	}
	
	@DeleteMapping("/{qid}")
	public void deleteQuestion(Authentication authentication, @PathVariable("qid") UUID qid) throws UserNotFoundException, QuestionNotFoundException {
		String email = authentication.getName();
		questionService.deleteQuestion(qid, email);		
	}
	
	@GetMapping("/page/{page_no}/size/{size}")
	public ResponseEntity<List<Question>> getPagedAllQuestions(@PathVariable("page_no") int pageNo, @PathVariable("size") int size) {
		return ResponseEntity.ok(questionService.fetchPagedAllQuestions(pageNo, size));
	}

	@GetMapping("/topic/{topicName}/all")
	public ResponseEntity<List<Question>> getAllQuestionUnderSpecificTopic(
			@PathVariable("topicName") String topicName) {
		return ResponseEntity.ok(questionService.fetchAllQuestionOfTopic(topicName));
	}

	@GetMapping("/topic/{topicName}/count")
	public ResponseEntity<Long> getAllQuestionUnderSpecificTopicCount(@PathVariable("topicName") String topicName) {
		return ResponseEntity.ok(questionService.countAllQuestionsByTopicName(topicName));
	}

	@GetMapping("/topic/{topicName}/page/{page_no}/size/{size}")
	public ResponseEntity<List<Question>> getPagedQuestionUnderSpecificTopic(
			@PathVariable("topicName") String topicName, @PathVariable("page_no") int pageNo,
			@PathVariable("size") int size) {
		return ResponseEntity.ok(questionService.fetchPagedQuestionOfTopic(topicName, pageNo, size));
	}

	@GetMapping("/user/{userId}/all")
	public ResponseEntity<List<Question>> getAllQuestionUnderSpecificUser(@PathVariable("userId") UUID userId) {
		return ResponseEntity.ok(questionService.fetchAllQuestionOfUserId(userId));
	}

	@GetMapping("/user/{userId}/count")
	public ResponseEntity<Long> getAllQuestionUnderSpecificUserCount(@PathVariable("userId") UUID userId) {
		return ResponseEntity.ok(questionService.countAllQuestionsByUserId(userId));
	}

	@GetMapping("/user/{userId}/page/{page_no}/size/{size}")
	public ResponseEntity<List<Question>> getPagedQuestionUnderSpecificUser(@PathVariable("userId") UUID userId,
			@PathVariable("page_no") int pageNo, @PathVariable("size") int size) {
		return ResponseEntity.ok(questionService.fetchPagedQuestionOfUserId(userId, pageNo, size));
	}

}
