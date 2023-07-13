package com.karthitox.oneforum.model;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(insertable = false, updatable = false, nullable = false)
	private UUID tid;

	@Column(unique = true, updatable = false, nullable = false)
	private String topicName;

	@LazyCollection(LazyCollectionOption.EXTRA)
	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Question> questions;
	
	@Transient
	private long totalQuestions;

	public Topic() {
	}

	public UUID getTid() {
		return tid;
	}

	public void setTid(UUID tid) {
		this.tid = tid;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> posts) {
		this.questions = posts;
	}
	
	public long getTotalQuestions() {
		return questions != null ? questions.size() : 0;
	}

	@Override
	public String toString() {
		return "Topic [tid=" + tid + ", TopicName=" + topicName + ", posts=" + questions + "]";
	}

}
