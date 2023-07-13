--users

insert into users values(
'92ad197b-af1d-4aa7-8b3c-cc4fb2f07ebd', 
'tester2@test.com', 
'tester2', 
'$2a$10$Fyf4gkE9gl0jvOMQAjyQKOtTWR.v4G201uhet4uV0RYiU5cS9O8nK', 'USER'
);

-- topics

insert into topic values(
'f6aac865-1cf4-41d3-a11a-c406ce6f3712',
'topic2'
);

-- question

insert into question values(
'22907b34-de06-4714-b559-5af9b2e9d69d', -- qid
'question 1', -- content
'2023-05-23 19:58:29.74997', -- ccreated at
'92ad197b-af1d-4aa7-8b3c-cc4fb2f07ebd', -- user (forign key)
'f6aac865-1cf4-41d3-a11a-c406ce6f3712' -- topic (topic id)
);

-- answer

insert into answer values (
  '7c39d39f-0dff-4b30-9464-3b7c6c4cb2ee', -- aid
  'answer 1', -- answer content
  '2023-05-23 20:10:36.739444',
  '92ad197b-af1d-4aa7-8b3c-cc4fb2f07ebd', -- user (forign key)
  '22907b34-de06-4714-b559-5af9b2e9d69d' -- qid (forign key)
);


-- vote 

insert into vote values (
  '92ad197b-af1d-4aa7-8b3c-cc4fb2f07ebd', -- answer (forign key)
  '7c39d39f-0dff-4b30-9464-3b7c6c4cb2ee' -- voter (forign key)
);