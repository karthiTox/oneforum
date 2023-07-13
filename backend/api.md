# Auth API

POST api/auth/register *returns token*
POST api/auth/login *returns token*
GET  api/auth/user *(PROTECTED)*

# Topic API

GET  api/topic/all
GET  api/topic/page/{pageNo}

# Question API

POST api/question *(PROTECTED)*

GET  api/question/topic/{topicName}/all
GET  api/question/topic/{topicName}/count
GET  api/question/topic/{topicName}/page/{pageNo}

GET  api/question/user/{userID}/all
GET  api/question/user/{userID}/count
GET  api/question/user/{userID}/page/{pageNo}

# Answer API

POST api/answer/{questionId} *(PROTECTED)*

GET  api/answer/{questionId}/all
GET  api/answer/{questionId}/page/{pageNo}

# Vote API

POST   api/vote/answer/{answerId}
DELETE api/vote/answer/{answerId}
GET    api/vote/answer/{answerId}/count

## SAMPLE RESPONSES
```json
{
    user : {
        uid,
        username,
        email,    
        password
    },

    topic : {
        tid,
        topic_name,
    },

    question : {
        qid,
        owner_id,
        topic_id,
        content,
        created_at,
    },

    answer : {
        aid,
        owner_id,
        question_id,
        content,
        created_at,

        isCurrentUserVoted,
        total_votes
    },

    vote : {
        answer_id,
        owner_id
    }
}
```
### POST api/auth/authenticate

{
    email,
    password
}

{
    user {
        uid,
        username,
        email
    },
    token
}

### GET api/auth/user

user

### GET api/topic/all

[
    {
        topicId,
        topicName,
        total_questions
    },
    {
        topicId,
        topicName,
        total_questions
    }
]

### POST api/question *(PROTECTED)*

{
    content,
    topicName,
}

question