package com.karthitox.oneforum.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.karthitox.oneforum.exception.*;
import com.karthitox.oneforum.model.Question;
import com.karthitox.oneforum.model.Topic;
import com.karthitox.oneforum.model.User;
import com.karthitox.oneforum.repository.QuestionRepository;
import com.karthitox.oneforum.repository.TopicRepository;
import com.karthitox.oneforum.repository.UserRepository;

@Service
public class QuestionService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TopicRepository topicRepository;
	@Autowired
	private QuestionRepository questionRepository;

	public Optional<Topic> createTopic(String topicName) {

		Optional<Topic> topic = topicRepository.findByTopicName(topicName);

		if (topic.isEmpty()) {
			Topic newTopic = new Topic();
			newTopic.setTopicName(topicName);

			log.debug("created new topic " + newTopic);
			;
			topic = Optional.of(topicRepository.save(newTopic));
		}

		return topic;

	}

	public Question createQuestion(String content, String email, String topicName)
			throws UserNotFoundException, TopicNotFoundException {

		Question post = new Question();

		Optional<User> owner = userRepository.findByEmail(email);
		Optional<Topic> topic = createTopic(topicName);

		if (owner.isEmpty()) {
			log.error("User not found while creating question");
			throw new UserNotFoundException("owner is need to create question or post question");
		}

		if (topic.isEmpty()) {
			log.error("Topic not found while creating question");
			throw new TopicNotFoundException("topic is needed, question should be posted under some topic");
		}

		post.setContent(content);
		post.setOwner(owner.get());
		post.setTopic(topic.get());

		return questionRepository.save(post);

	}

//	public List<QuerecommendQuestionsForUser(UUID userId){
//		List<Topic> topics = topicRepository.findTopRatedTopicsOfUser(userId);
//
//		questionRepositorystion> .findByTopic()
//	}

	public void deleteQuestion(UUID qid, String email) throws UserNotFoundException, QuestionNotFoundException {
		Question question = questionRepository.findById(qid).orElseThrow(() -> new QuestionNotFoundException());
		User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());
		
		if (question.getOwner().getUid() == user.getUid()) {
			questionRepository.deleteById(qid);
		}

	}

	public Question fetchQuestionById(UUID qid) throws QuestionNotFoundException {
		return questionRepository.findById(qid).orElseThrow(() -> new QuestionNotFoundException());
	}

	public List<Question> fetchAllQuestions() {
		return questionRepository.findAllDesc();
	}

	public List<Question> fetchPagedAllQuestions(int pageNo, int size) {
		return questionRepository.findAllDesc(PageRequest.of(pageNo, size)).toList();
	}

	// by topic

	public List<Question> fetchAllQuestionOfTopic(String topicName) {
		return questionRepository.findAllQuestionsByTopicName(topicName);
	}

	public List<Question> fetchPagedQuestionOfTopic(String topicName, int pageNo, int size) {
		return questionRepository.findPagedQuestionsByTopicName(topicName, PageRequest.of(pageNo, size)).toList();
	}

	public long countAllQuestionsByTopicName(String topicName) {
		return questionRepository.countAllQuestionsByTopicName(topicName);
	}

	// by user

	public List<Question> fetchAllQuestionOfUserId(UUID UserId) {
		return questionRepository.findAllQuestionsByUserId(UserId);
	}

	public List<Question> fetchPagedQuestionOfUserId(UUID UserId, int pageNo, int size) {
		return questionRepository.findPagedQuestionsByUserId(UserId, PageRequest.of(pageNo, size)).toList();
	}

	public long countAllQuestionsByUserId(UUID UserId) {
		return questionRepository.countAllQuestionsByUserId(UserId);
	}

}
