package com.karthitox.oneforum.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.karthitox.oneforum.model.Answer;
import com.karthitox.oneforum.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Answer> {
	
	@Query("select count(v) from Vote v where v.answer.aid = :aid")
	long countAllVotesForAnswer(@Param("aid") UUID aid);
	
	
}