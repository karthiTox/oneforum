package com.karthitox.oneforum.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.karthitox.oneforum.model.Answer;
import com.karthitox.oneforum.model.Question;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, UUID> {

	@Query("select a from Answer a where a.question.qid = :qid")
	List<Answer> findAllAnswersOfQuestion(@Param("qid") UUID questionId);
	
	@Query("select count(*) from Answer a where a.question.qid = :qid")
	long countAllAnswersOfQuestion(@Param("qid") UUID questionId);
	
	@Query("select a from Answer a where a.question.qid = :qid")
	Page<Answer> findPagedAnswersOfQuestion(@Param("qid") UUID questionId, Pageable pageable);
	
	
}