package com.karthitox.oneforum.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.karthitox.oneforum.model.Question;
import com.karthitox.oneforum.model.Topic;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
	
	List<Question> findByTopic(Topic topic);
	
	@Query("select q from Question q order by q.createdAt desc")
	List<Question> findAllDesc();
	
	@Query("select q from Question q order by q.createdAt desc")
	Page<Question> findAllDesc(Pageable pageable);
	
	// fetch questions of respective topic;
	
	@Query("select q from Question q join q.topic t where t.topicName = :topic_name order by q.createdAt desc")
	List<Question> findAllQuestionsByTopicName(@Param("topic_name") String topicName);
	
	@Query("select count(q) from Question q join q.topic t where t.topicName = :topic_name")
	long countAllQuestionsByTopicName(@Param("topic_name") String topicName);
	
	@Query("select q from Question q join q.topic t where t.topicName = :topic_name order by q.createdAt desc")
	Page<Question> findPagedQuestionsByTopicName(@Param("topic_name") String topicName, Pageable pageable);
	
	
	// fetch questions of respective user;
	
	@Query("select q from Question q join q.owner o where o.uid = :userId order by q.createdAt desc")
	List<Question> findAllQuestionsByUserId(@Param("userId") UUID userId);
	
	@Query("select count(q) from Question q join q.owner o where o.uid = :userId")
	long countAllQuestionsByUserId(@Param("userId") UUID userId);
	
	@Query("select q from Question q join q.owner o where o.uid = :userId order by q.createdAt desc")	
	Page<Question> findPagedQuestionsByUserId(@Param("userId") UUID userId, Pageable pageable);
	
}