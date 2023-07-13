package com.karthitox.oneforum.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.karthitox.oneforum.model.serializer.TopicSerializer;
import com.karthitox.oneforum.model.serializer.UserSerializer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@ToString
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, insertable = false, updatable = false, nullable = false)
	private UUID qid;

	@ManyToOne(optional = false)
	@JoinColumn(name = "topicId", nullable = false, referencedColumnName = "tid")
	private Topic topic;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "ownerId", nullable = false, referencedColumnName = "uid")
	private User owner;

	@Column
	private String content;

	@Column(columnDefinition = "datetime")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	
	@LazyCollection(LazyCollectionOption.EXTRA)
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Answer> answers;
	
	@Transient
    private long totalAnswers;

	
	public Question() {
	}


	public UUID getQid() {
		return qid;
	}


	public void setQid(UUID qid) {
		this.qid = qid;
	}


	public Topic getTopic() {
		return topic;
	}


	public void setTopic(Topic topic) {
		this.topic = topic;
	}


	public User getOwner() {
		return owner;
	}


	public void setOwner(User owner) {
		this.owner = owner;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getCreatedAt() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return createdAt.format(formatter);		
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public List<Answer> getAnswers() {
		return answers;
	}


	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public long getTotalAnswers() {
		return answers != null ? answers.size() : 0;
	}

	
	
}
