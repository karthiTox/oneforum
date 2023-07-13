package com.karthitox.oneforum.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.karthitox.oneforum.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, UUID> {

	Optional<Topic> findByTopicName(String topicName);
	
	@Query("select q.topic from Vote v join v.answer a join a.question q where v.voter.uid = :uid group by q.topic.tid order by sum(1) desc") 
	List<Topic> findTopRatedTopicsOfUser(@Param("uid") UUID uid);
}