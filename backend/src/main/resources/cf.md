```sql
-- Calculate similarities between all users
CREATE TABLE user_similarity (
  user1_id INT NOT NULL,
  user2_id INT NOT NULL,
  similarity FLOAT,
  PRIMARY KEY (user1_id, user2_id)
);

INSERT INTO user_similarity (user1_id, user2_id, similarity)
SELECT
  u1.uid AS user1_id,
  u2.uid AS user2_id,
  SUM(q1v.vote*q2v.vote)/(SQRT(SUM(q1v.vote*q1v.vote)) * SQRT(SUM(q2v.vote*q2v.vote))) AS similarity
FROM user u1
JOIN user u2 ON u1.uid < u2.uid
JOIN vote q1v ON q1v.voter_id = u1.uid
JOIN vote q2v ON q2v.voter_id = u2.uid AND q2v.answer_id = q1v.answer_id
GROUP BY u1.uid, u2.uid;

-- Calculate predictions
CREATE TABLE question_prediction (
  user_id INT NOT NULL,
  question_id INT NOT NULL,
  prediction FLOAT,
  PRIMARY KEY (user_id, question_id)
);

INSERT INTO question_prediction (user_id, question_id, prediction)
SELECT
  u.uid AS user_id,
  q.qid AS question_id,
  SUM(us.similarity * v.vote) / SUM(ABS(us.similarity)) AS prediction
FROM user u
JOIN vote v ON v.voter_id = u.uid
JOIN answer a ON a.aid = v.answer_id
JOIN question q ON q.qid = a.question_id
LEFT JOIN user_similarity us ON us.user1_id = u.uid AND us.user2_id = a.owner_id
GROUP BY u.uid, q.qid;
```


-- 2

```sql
SELECT v1.voter_id as user1, v2.voter_id as user2, 
  COUNT(DISTINCT v1.answer_id) as num_common_votes, 
  COUNT(DISTINCT v2.answer_id) as user2_total_votes,
  COUNT(DISTINCT v1.answer_id) / SQRT(COUNT(DISTINCT v1.answer_id) * COUNT(DISTINCT v2.answer_id)) as similarity
FROM vote v1
JOIN vote v2 ON v1.answer_id = v2.answer_id AND v1.voter_id < v2.voter_id
GROUP BY v1.voter_id, v2.voter_id
HAVING COUNT(DISTINCT v1.answer_id) > 0;
```

```js
similarity(u1, u2) = 
sum(vote(u1, a) * vote(u2, a)) / (sqrt(sum(vote(u1, a)^2)) * sqrt(sum(vote(u2, a)^2)))
```

```js
prediction(u, q) = sum(similarity(u, v) * vote(v, a)) / sum(abs(similarity(u, v)))
```

