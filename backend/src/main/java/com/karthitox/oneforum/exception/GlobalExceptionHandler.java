package com.karthitox.oneforum.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.karthitox.oneforum.model.dto.ErrorResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleUserNotFoundException() {
		ErrorResponseDTO errorResponse = new ErrorResponseDTO();
		errorResponse.setCode(404);
		errorResponse.setMessage("User not found in the database");

		return ResponseEntity.status(404).body(errorResponse);
	}

	@ExceptionHandler(value = UserAlreadyExistException.class)
	public ResponseEntity<ErrorResponseDTO> handleUserAlreadyExistException() {
		ErrorResponseDTO errorResponse = new ErrorResponseDTO();
		errorResponse.setCode(409);
		errorResponse.setMessage("User already exists in the database");

		return ResponseEntity.status(409).body(errorResponse);
	}
	
	@ExceptionHandler(value = TopicNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleTopicNotFoundException() {
		ErrorResponseDTO errorResponse = new ErrorResponseDTO();
		errorResponse.setCode(404);
		errorResponse.setMessage("Topic not found in the database");

		return ResponseEntity.status(404).body(errorResponse);
	}
	
	@ExceptionHandler(value = QuestionNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleQuestionNotFoundException() {
		ErrorResponseDTO errorResponse = new ErrorResponseDTO();
		errorResponse.setCode(404);
		errorResponse.setMessage("Question not found in the database");

		return ResponseEntity.status(404).body(errorResponse);
	}
	
	@ExceptionHandler(value = AnswerNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleAnswerNotFoundException() {
		ErrorResponseDTO errorResponse = new ErrorResponseDTO();
		errorResponse.setCode(404);
		errorResponse.setMessage("Answer not found in the database");

		return ResponseEntity.status(404).body(errorResponse);
	}
	
	@ExceptionHandler(value = {Exception.class, RuntimeException.class})
	public ResponseEntity<ErrorResponseDTO> handleException(HttpServletRequest request, Exception e) {
		ErrorResponseDTO errorResponse = new ErrorResponseDTO();
		errorResponse.setCode(500);
		errorResponse.setMessage(e.getMessage());

		return ResponseEntity.status(400).body(errorResponse);
	}
}
