package com.karthitox.oneforum.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.karthitox.oneforum.model.serializer.QuestionSerializer;
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
import jakarta.persistence.Transient;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, insertable = false, updatable = false, nullable = false)
	private UUID aid;

	@ManyToOne(optional = false)
	@JoinColumn(name = "questionId", nullable = false, referencedColumnName = "qid")	
	@JsonSerialize(using = QuestionSerializer.class)	
	private Question question;

	@ManyToOne(optional = false)
	@JoinColumn(name = "ownerId", nullable = false, referencedColumnName = "uid")
	private User owner;

	@Column
	private String content;

	@Column(columnDefinition = "datetime")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@LazyCollection(LazyCollectionOption.EXTRA)
	@OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JsonIgnore
	private List<Vote> votes;
		
	@Transient
    private long totalVotes;

	public Answer() {
	}

	public UUID getAid() {
		return aid;
	}

	public void setAid(UUID aid) {
		this.aid = aid;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
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

	public List<Vote> getVotes() {
		return votes == null ? new ArrayList<Vote>() : votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public long getTotalVotes() {
		return votes != null ? votes.size() : 0;
	}
	
	
	
	

}
