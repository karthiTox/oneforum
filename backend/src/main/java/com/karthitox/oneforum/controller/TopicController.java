package com.karthitox.oneforum.controller;

import java.util.List;
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

import com.karthitox.oneforum.model.Topic;
import com.karthitox.oneforum.model.Vote;
import com.karthitox.oneforum.service.TopicService;
import com.karthitox.oneforum.service.VoteService;

@RestController
@RequestMapping("/api/topic")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping("/all")
	public ResponseEntity<List<Topic>> getAllTopics() {
		return ResponseEntity.ok(topicService.fetchAllTopics());
	}

	@GetMapping("/page/{pageNo}/size/{size}")
	public ResponseEntity<List<Topic>> getAllTopics(@PathVariable("pageNo") int pageNo,
			@PathVariable("size") int size) {
		return ResponseEntity.ok(topicService.fetchAllTopics(pageNo, size));
	}
}
