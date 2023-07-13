package com.karthitox.oneforum.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.karthitox.oneforum.model.*;
import com.karthitox.oneforum.repository.*;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> fetchAllTopics() {
		return topicRepository.findAll();
	}

	public List<Topic> fetchAllTopics(int pageNo, int size) {
		return topicRepository.findAll(PageRequest.of(pageNo, size)).toList();
	}

}
