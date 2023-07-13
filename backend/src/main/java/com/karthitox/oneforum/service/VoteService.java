package com.karthitox.oneforum.service;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthitox.oneforum.exception.AnswerNotFoundException;
import com.karthitox.oneforum.exception.UserNotFoundException;
import com.karthitox.oneforum.model.*;
import com.karthitox.oneforum.repository.*;

@Service
public class VoteService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AnswerRepository answerRepository;
	@Autowired
	private VoteRepository voteRepository;

	public Vote addVote(String email, UUID answerId) throws UserNotFoundException, AnswerNotFoundException {

		Optional<User> voter = userRepository.findByEmail(email);
		Optional<Answer> answer = answerRepository.findById(answerId);

		if (voter.isEmpty()) {
			log.error("Vote not found while creating vote");			
			throw new UserNotFoundException("voter not found");
		}

		if (answer.isEmpty()) {
			log.error("Answer not found while creating vote");
			throw new AnswerNotFoundException("parent answer not found");
		}

		Vote vote = new Vote();
		vote.setAnswer(answer.get());
		vote.setVoter(voter.get());

		return voteRepository.save(vote);
	}

	public void deleteVote(String email, UUID answerId) throws UserNotFoundException, AnswerNotFoundException {

		Optional<User> voter = userRepository.findByEmail(email);
		Optional<Answer> answer = answerRepository.findById(answerId);

		if (voter.isEmpty()) {
			log.error("User not found while del vote");
			throw new UserNotFoundException("voter not found");
		}

		if (answer.isEmpty()) {
			log.error("Answer not found while del vote");
			throw new AnswerNotFoundException("parent answer not found");
		}

		Vote vote = new Vote();

		vote.setAnswer(answer.get());
		vote.setVoter(voter.get());

		voteRepository.delete(vote);
	}

	public long countAllVotesForAnswer(UUID answerId) {
		return voteRepository.countAllVotesForAnswer(answerId);
	}

}
