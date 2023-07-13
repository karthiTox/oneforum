package com.karthitox.oneforum.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthitox.oneforum.exception.AnswerNotFoundException;
import com.karthitox.oneforum.exception.UserNotFoundException;
import com.karthitox.oneforum.model.Vote;
import com.karthitox.oneforum.service.VoteService;

@RestController
@RequestMapping("/api/vote")
public class VoteController {

	@Autowired
	private VoteService voteService;

	@PostMapping("answer/{answerId}")
	public ResponseEntity<Vote> postVote(Authentication authentication, @PathVariable("answerId") UUID answerId) throws UserNotFoundException, AnswerNotFoundException
			 {

		String email = authentication.getName();

		return ResponseEntity.ok(voteService.addVote(email, answerId));
	}

	@DeleteMapping("answer/{answerId}")
	public void deleteVote(Authentication authentication, @PathVariable("answerId") UUID answerId) throws UserNotFoundException, AnswerNotFoundException
		 {

		String email = authentication.getName();

		voteService.deleteVote(email, answerId);

	}

	@GetMapping("answer/{answerId}/count")
	public Long getTotalVoteCount(@PathVariable("answerId") UUID answerId) {

		return voteService.countAllVotesForAnswer(answerId);
	}
}
