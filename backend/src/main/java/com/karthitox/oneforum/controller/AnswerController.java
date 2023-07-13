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

import com.karthitox.oneforum.exception.AnswerNotFoundException;
import com.karthitox.oneforum.exception.QuestionNotFoundException;
import com.karthitox.oneforum.exception.UserNotFoundException;
import com.karthitox.oneforum.model.Answer;
import com.karthitox.oneforum.model.dto.AnswerCreationRequestDTO;
import com.karthitox.oneforum.service.AnswerService;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@PostMapping()
	public ResponseEntity<Answer> addAnswer(Authentication authentication,
			@RequestBody AnswerCreationRequestDTO answerCreationRequest)
			throws UserNotFoundException, QuestionNotFoundException {
		String email = authentication.getName();

		return ResponseEntity.ok(answerService.addAnswer(email, answerCreationRequest.getQuestionId(),
				answerCreationRequest.getContent()));
	}
	
	@DeleteMapping("/{aid}")
	public void deleteAnswer(Authentication authentication, @PathVariable("aid") UUID aid) throws UserNotFoundException, AnswerNotFoundException {
		String email = authentication.getName();
		answerService.deleteAnswer(aid, email);
	}

	@GetMapping("/{questionId}/all")
	public ResponseEntity<List<Answer>> getAllAnswer(
			@PathVariable("questionId") UUID questionId
	){

	return ResponseEntity.ok(answerService.fetchAllAnswersOfQuestion(questionId));
	}

	@GetMapping("/{questionId}/count")
	public ResponseEntity<Long> getAllAnswerCount(
			@PathVariable("questionId") UUID questionId
	){

	return ResponseEntity.ok(answerService.countAllAnswersOfQuestion(questionId));
	}

	@GetMapping("/{questionId}/page/{pageNo}/size/{size}")
	public ResponseEntity<List<Answer>> getAllAnswer(
			@PathVariable("questionId") UUID questionId,
			@PathVariable("pageNo") int pageNo,
			@PathVariable("size") int size
	){
		return ResponseEntity.ok(answerService.fetchPagedAnswersOfQuestion(questionId, pageNo, size));

	}
}
