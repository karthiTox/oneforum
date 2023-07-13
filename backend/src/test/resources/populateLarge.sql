-- Inserting users 
INSERT INTO users
VALUES
  ('a9c69d1e-758d-4fe9-ae13-21d2df1fe118', 'user1@test.com', 'John Doe', '$2a$10$Fyf4gkE9gl0jvOMQAjyQKOtTWR.v4G201uhet4uV0RYiU5cS9O8nK', 'USER'),
  ('d74a7a6b-7fdd-4df0-9f67-975d160a2f36', 'user2@test.com', 'Jane Smith', '$2a$10$Fyf4gkE9gl0jvOMQAjyQKOtTWR.v4G201uhet4uV0RYiU5cS9O8nK', 'USER'),
  ('17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', 'user3@test.com', 'Michael Johnson', '$2a$10$Fyf4gkE9gl0jvOMQAjyQKOtTWR.v4G201uhet4uV0RYiU5cS9O8nK', 'USER'),
  ('c24478ea-74b3-4ed1-93d3-8a638a0a9507', 'user4@test.com', 'Emily Davis', '$2a$10$Fyf4gkE9gl0jvOMQAjyQKOtTWR.v4G201uhet4uV0RYiU5cS9O8nK', 'USER'),
  ('ba9939fe-9f9d-4d5f-8a34-6e27ae986ad5', 'user5@test.com', 'William Wilson', '$2a$10$Fyf4gkE9gl0jvOMQAjyQKOtTWR.v4G201uhet4uV0RYiU5cS9O8nK', 'USER'),
  ('87db04e4-68be-4d1c-94d4-c72e4a2d5a8c', 'user6@test.com', 'Olivia Martinez', '$2a$10$Fyf4gkE9gl0jvOMQAjyQKOtTWR.v4G201uhet4uV0RYiU5cS9O8nK', 'USER');

-- Inserting topics 
INSERT INTO topic
VALUES
  ('ef9e16a4-5e3a-47fd-8c78-c4b5c1f8697c', 'javascript'),
  ('8a6477ce-60c9-4a34-889a-345b80d45002', 'python'),
  ('fd4e56c1-bb5d-4c25-849d-4f4d2fb5c6e0', 'java'),
  ('4b28cb02-8bea-4812-8f1f-3f981f866754', 'ruby'),
  ('a1c5a7a5-8a43-43d9-9586-3d0473a0f3e7', 'c++'),
  ('32e9eb0d-9825-43ef-bc72-0b3b2594bfa0', 'html'),
  ('b6515d68-098a-4f4c-a586-7f8ebf7b3d72', 'css'),
  ('7fd8b850-1ad5-4011-9e97-3f3c9e0b6d23', 'php'),
  ('cf1a092a-28ad-4db5-92bc-43e3a3775e7a', 'sql'),
  ('64ac4ee5-4f4f-4e9f-b71e-8c5d0b50c4a3', 'react'),
  ('9c79a770-b064-4129-b4a3-3e932ce22e46', 'angular'),
  ('e9f28b94-978b-491b-b1d3-f41879a77a16', 'node.js'),
  ('4ff6df72-5d68-4a86-bb06-21a3c11d3dd2', 'django'),
  ('27fe1a97-64eb-4d26-8e20-c428678e1bc4', 'laravel'),
  ('d827c7ef-0cfc-4321-bd82-df2f66af3b07', 'flutter'),
  ('f9849f84-937e-46db-bf7e-180438787f81', 'wordpress'),
  ('21b587ef-78c2-4b5d-8a94-38d7c3d2e16f', 'mongodb'),
  ('f3d0f0b0-7c1c-44e5-87e0-3b1c76f6d103', 'mysql'),
  ('ae081e5b-901a-4b72-af9a-0f2aee6c9e1e', 'aws'),
  --
  ('6f6d993f-3d7b-4d61-8a6a-79c3c193c3b1', 'vue.js'),
  ('9e753dcd-9646-4f2e-a8f4-2be4c2516b21', 'angularJS'),
  ('d0783832-231d-4ebe-bf8e-57f9a3d1b12c', 'express.js'),
  ('f7b9e47a-0d56-43d0-bda9-458d83d20b68', 'Spring Boot'),
  ('4e3e0137-7fd1-4dc1-9a1f-41842d3e0b84', 'Ruby on Rails'),
  ('5b0f97f6-8a6e-4aa4-9fd5-82118d02b98d', 'Go'),
  ('12a45c3e-249f-437b-a442-d293c7de70b4', 'Swift'),
  ('39482b8d-67e2-4d3e-a158-45d5bfe9376b', 'Kotlin'),
  ('a6b3b04d-84e1-44e2-a253-8d7f833e3b6e', 'C#'),
  ('1f0794c1-7382-48bc-b327-0c1efbe82b6f', 'Rust'),
  ('f82a13a5-0ec4-4f88-89f7-7c9b4e5e7e45', 'Scala'),
  ('8e44813f-47f1-45f4-bf28-36b61a51a4e0', 'Docker'),
  ('14e63ed4-b89e-4f99-8c35-ae0739b30919', 'Git'),
  ('e7d0064a-78a2-44e0-b39c-1a9f502c520d', 'GraphQL'),
  ('2f8db329-bbf0-4f9d-8fd4-61967703dd5d', 'TypeScript'),
  ('cd4a2a19-f450-42fc-b118-23e24a926b25', 'Machine Learning'),
  ('e96a1b27-cc13-475a-9e78-7b04e7d61ce7', 'Artificial Intelligence'),
  ('f29125e0-5646-4c0d-b537-751a5a14a2b1', 'Data Science'),
  ('76f181bc-c344-4a67-8a2d-6f87f8506b92', 'Cybersecurity'),
  ('bfc2fc0d-6601-4963-8a32-ba8d3d98b6f1', 'Blockchain');


INSERT INTO question
VALUES
  ('22907b34-de06-4714-b559-5af9b2e9d69d', 'What are JavaScript data types?', '2023-05-23 21:30:15.123456', 'a9c69d1e-758d-4fe9-ae13-21d2df1fe118', 'ef9e16a4-5e3a-47fd-8c78-c4b5c1f8697c'),
  ('3ac6d5a1-9f46-47ef-92f1-5d598d67b79e', 'How do I use loops in Python?', '2023-05-23 22:15:47.987654', 'd74a7a6b-7fdd-4df0-9f67-975d160a2f36', '8a6477ce-60c9-4a34-889a-345b80d45002'),
  ('1b383b0d-ef6b-445f-9565-6741cc8035a1', 'What is the difference between var, let, and const in JavaScript?', '2023-05-23 23:45:32.543210', '17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', 'ef9e16a4-5e3a-47fd-8c78-c4b5c1f8697c'),
  ('be09a0a0-24f5-4469-8c2f-dae79f73d3e7', 'How to handle exceptions in Python?', '2023-05-24 01:20:59.876543', 'a9c69d1e-758d-4fe9-ae13-21d2df1fe118', '8a6477ce-60c9-4a34-889a-345b80d45002'),
  ('4b5f1c42-ff37-42a5-89b2-2ae86c35c785', 'What is JavaScript event delegation?', '2023-05-24 03:10:25.135790', 'd74a7a6b-7fdd-4df0-9f67-975d160a2f36', 'ef9e16a4-5e3a-47fd-8c78-c4b5c1f8697c'),
  ('e4bca780-b289-4e8a-96c6-c7b9bb2ed757', 'How to handle file I/O in Python?', '2023-05-24 05:05:42.468975', '17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', '8a6477ce-60c9-4a34-889a-345b80d45002'),
  ('d6c0f450-2a76-4a5b-81df-1b8f285a09d1', 'What are the best practices for responsive web design?', '2023-05-24 09:25:17.159283', '17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', 'ef9e16a4-5e3a-47fd-8c78-c4b5c1f8697c'),
  ('5e132168-ef0a-4391-9a6d-ef3a4e56f9ad', 'How to handle errors and exceptions in JavaScript?', '2023-05-24 11:40:21.483215', 'd74a7a6b-7fdd-4df0-9f67-975d160a2f36', 'ef9e16a4-5e3a-47fd-8c78-c4b5c1f8697c'),
  ('d1d5b7a6-3eb5-4f2d-95f7-1b623a2dc9b0', 'What are the benefits of using Python for web development?', '2023-05-24 13:55:29.728134', 'a9c69d1e-758d-4fe9-ae13-21d2df1fe118', '8a6477ce-60c9-4a34-889a-345b80d45002'),
  ('8e2b1a0e-2d35-4b18-bb23-83be974c4e3d', 'What are the different ways to loop through an array in JavaScript?', '2023-05-24 15:10:45.042893', '17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', 'ef9e16a4-5e3a-47fd-8c78-c4b5c1f8697c'),
  ('f93f89e6-47fb-4b72-9e57-0e498f2860c6', 'How to perform string manipulation in Python?', '2023-05-24 16:25:59.387612', 'd74a7a6b-7fdd-4df0-9f67-975d160a2f36', '8a6477ce-60c9-4a34-889a-345b80d45002'),
  ('6b9503e2-c76e-4da1-9e8c-b8ce14a6e590', 'What is the role of event-driven programming in JavaScript?', '2023-05-24 18:40:17.592387', 'a9c69d1e-758d-4fe9-ae13-21d2df1fe118', 'ef9e16a4-5e3a-47fd-8c78-c4b5c1f8697c'),
  ('a7420a07-dc92-4b15-8a4f-198a1df22a39', 'What are the best practices for secure JavaScript coding?', '2023-05-24 20:55:31.842176', '17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', 'ef9e16a4-5e3a-47fd-8c78-c4b5c1f8697c'),
  ('8c579cda-3f3d-42f7-a19c-14e8bfb098e7', 'What are the advantages of using Python over other programming languages?', '2023-05-24 23:10:49.125438', 'd74a7a6b-7fdd-4df0-9f67-975d160a2f36', '8a6477ce-60c9-4a34-889a-345b80d45002'),
  ('6b4c7c92-9000-416a-8446-27b5e63a07a1', 'How to handle asynchronous operations in JavaScript?', '2023-05-25 01:25:57.394725', 'a9c69d1e-758d-4fe9-ae13-21d2df1fe118', 'ef9e16a4-5e3a-47fd-8c78-c4b5c1f8697c'),
  ('95338b4e-0e4d-4b60-89e9-746c2ddbb9a2', 'What are the different data structures available in Python?', '2023-05-25 03:40:05.676312', '17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', '8a6477ce-60c9-4a34-889a-345b80d45002'),
  ('1fb4e888-4136-45d1-a1f0-ef4ae1803df8', 'How to handle form validation in JavaScript?', '2023-05-25 05:55:13.972561', 'd74a7a6b-7fdd-4df0-9f67-975d160a2f36', 'ef9e16a4-5e3a-47fd-8c78-c4b5c1f8697c'),
  ('9dfba840-d50d-4f68-84d4-2347f4d784c9', 'What are the file handling capabilities of Python?', '2023-05-25 08:10:22.274531', 'a9c69d1e-758d-4fe9-ae13-21d2df1fe118', '8a6477ce-60c9-4a34-889a-345b80d45002'),
  ('6f11c46d-978b-4ebe-b7d6-4910b8559f5a', 'How to optimize JavaScript code for better performance?', '2023-05-25 10:25:30.586493', 'a9c69d1e-758d-4fe9-ae13-21d2df1fe118', 'ef9e16a4-5e3a-47fd-8c78-c4b5c1f8697c'),
  ('e356c30a-10a1-4e29-95f2-14867532c12b', 'What are the built-in modules in Python?', '2023-05-25 12:40:40.913274', 'd74a7a6b-7fdd-4df0-9f67-975d160a2f36', '8a6477ce-60c9-4a34-889a-345b80d45002'),
  ('d7a8b4e2-41f3-4c7b-93a1-268e4138e53a', 'How to handle events in JavaScript?', '2023-05-25 14:55:51.246832', '17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', 'ef9e16a4-5e3a-47fd-8c78-c4b5c1f8697c'),
  ('4c6de959-3d0a-4e14-9a50-ef0ed8b47ed5', 'What are the different ways to handle errors in Python?', '2023-05-25 17:11:01.587421', 'a9c69d1e-758d-4fe9-ae13-21d2df1fe118', '8a6477ce-60c9-4a34-889a-345b80d45002'),
  ('6db9c4e7-3c19-4c23-99f1-1b88a1a0e441', 'How to manipulate the DOM using JavaScript?', '2023-05-25 19:26:12.934386', 'd74a7a6b-7fdd-4df0-9f67-975d160a2f36', 'ef9e16a4-5e3a-47fd-8c78-c4b5c1f8697c'),
  ('826a6b10-f874-4b4f-9dfb-6639e15b8e19', 'What are the different data types in Python?', '2023-05-25 21:41:24.287593', '17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', '8a6477ce-60c9-4a34-889a-345b80d45002');


INSERT INTO answer
VALUES
  ('ae6c5f6d-58af-4f47-9af4-0c189e63a99e', 'JavaScript data types include string, number, boolean, null, undefined, object, and symbol.', '2023-05-25 09:20:35.987654', 'ba9939fe-9f9d-4d5f-8a34-6e27ae986ad5', '22907b34-de06-4714-b559-5af9b2e9d69d'),
  ('5d26783a-8880-4e3e-84ae-55619413c82a', 'Loops in Python can be used to iterate over a sequence of elements or perform a set of statements repeatedly. Common types of loops in Python are for loops, while loops, and nested loops.', '2023-05-25 10:35:17.654321', '87db04e4-68be-4d1c-94d4-c72e4a2d5a8c', '3ac6d5a1-9f46-47ef-92f1-5d598d67b79e'),
  ('baff516e-7e17-4df1-9b48-8b46cc3e7034', 'In JavaScript, var, let, and const are used to declare variables. var has a function scope, let has a block scope, and const is used for constants with a block scope.', '2023-05-25 11:50:12.543210', 'ba9939fe-9f9d-4d5f-8a34-6e27ae986ad5', '1b383b0d-ef6b-445f-9565-6741cc8035a1'),
  ('8c63c727-65a7-4405-a96e-2c3ab4203948', 'Exceptions in Python can be handled using try-except blocks. The code that might raise an exception is enclosed in the try block, and the code to handle the exception is written in the except block.', '2023-05-25 13:05:45.876543', 'c24478ea-74b3-4ed1-93d3-8a638a0a9507', 'be09a0a0-24f5-4469-8c2f-dae79f73d3e7'),
  ('ea91c8f7-5e8c-4f97-b38f-5c7830bda5d0', 'JavaScript event delegation is a technique where instead of attaching an event listener to each individual element, a single event listener is attached to a parent element. This allows handling events for dynamically added or removed child elements.', '2023-05-25 14:30:25.135790', '17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', '4b5f1c42-ff37-42a5-89b2-2ae86c35c785'),
  ('01a7b85c-6ef8-4a32-bef9-3d345a47f5b3', 'JavaScript data types refer to the different types of values that can be assigned to variables. The basic data types in JavaScript include string, number, boolean, null, undefined, and symbol.', '2023-05-23 21:35:42.987654', 'a9c69d1e-758d-4fe9-ae13-21d2df1fe118', '22907b34-de06-4714-b559-5af9b2e9d69d'),
  ('536aad4e-5b35-4536-9487-2e84e968dcd2', 'Loops in Python are used to repeatedly execute a block of code until a certain condition is met. There are different types of loops in Python, including for loops, while loops, and do-while loops.', '2023-05-23 22:20:15.234567', 'd74a7a6b-7fdd-4df0-9f67-975d160a2f36', '3ac6d5a1-9f46-47ef-92f1-5d598d67b79e'),
  ('c1639c4f-8a8e-45f6-98ed-00dd3bfcf5a7', 'In JavaScript, var, let, and const are used to declare variables. The main difference between them is their scope and hoisting behavior. var has function scope and is hoisted', '2023-05-23 23:50:32.543210', '17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', '1b383b0d-ef6b-445f-9565-6741cc8035a1'),
  ('7feab5bc-c8d4-4df1-bcee-47807d336594', 'Exception handling in Python allows you to handle errors and exceptions that occur during program execution. It helps prevent the program from crashing and allows you to gracefully handle unexpected situations.', '2023-05-24 01:25:59.876543', 'a9c69d1e-758d-4fe9-ae13-21d2df1fe118', 'be09a0a0-24f5-4469-8c2f-dae79f73d3e7'),
  ('46ab0d0d-899f-4f79-8a68-d59b4c1a1db4', 'JavaScript event delegation is a technique where you attach an event handler to a parent element instead of individual child elements. This allows you to handle events on dynamically added or removed child elements.', '2023-05-24 03:15:25.135790', 'd74a7a6b-7fdd-4df0-9f67-975d160a2f36', '4b5f1c42-ff37-42a5-89b2-2ae86c35c785'),
  --extrs
  ('d5e07709-150c-4eae-bacc-0ee4dd7351ea', 'Numeric types: int, float, complex for handling numbers in Python.', '2023-05-23 21:25:30.032623', 'ba9939fe-9f9d-4d5f-8a34-6e27ae986ad5',	'826a6b10-f874-4b4f-9dfb-6639e15b8e19'),
  ('4b16ca9d-1bb2-4723-8fc0-1fb792216a6c', 'Sequence types: list, tuple, range used for ordered collections.', '2023-05-23 21:26:14.142588', 'd74a7a6b-7fdd-4df0-9f67-975d160a2f36',	'826a6b10-f874-4b4f-9dfb-6639e15b8e19'),
  ('dcfb233d-8885-4b0c-aa78-de1377364e2e', 'Mapping type: dict for key-value pairs and dictionary operations. Set types: set, frozenset for storing unique and unordered elements.', '2023-05-23 21:26:24.429459', 'd74a7a6b-7fdd-4df0-9f67-975d160a2f36',	'826a6b10-f874-4b4f-9dfb-6639e15b8e19'),
  ('ed64da73-7881-417a-b9aa-2ec9f3a23e01', 'Use JavaScript\s querySelector and querySelectorAll methods to select DOM elements.', '2023-05-23 21:27:49.215955', '17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2',	'6db9c4e7-3c19-4c23-99f1-1b88a1a0e441'),
  ('b2a54adf-756d-40e5-8f41-a50bfe77c145', 'Modify element properties like innerHTML, textContent, or setAttribute to change content and attributes.', '2023-05-23 21:28:27.123751', '87db04e4-68be-4d1c-94d4-c72e4a2d5a8c',	'6db9c4e7-3c19-4c23-99f1-1b88a1a0e441'),
  ('ca966b77-5759-48b8-84ff-55341dd30a5f', 'Attach event listeners to DOM elements using methods like addEventListener to respond to user actions.', '2023-05-23 21:28:54.324183', '87db04e4-68be-4d1c-94d4-c72e4a2d5a8c',	'd7a8b4e2-41f3-4c7b-93a1-268e4138e53a'),
  ('d1f8f36a-153f-403b-843d-69b8ae68c35f', 'Handle events with event handlers or callback functions to execute specific actions or trigger functionality in response to events', '	2023-05-23 21:28:59.74217', '87db04e4-68be-4d1c-94d4-c72e4a2d5a8c',	'd7a8b4e2-41f3-4c7b-93a1-268e4138e53a'),
  ('6e8588cb-2ab5-4b95-ab56-28c39a5d47eb', 'Use try-except blocks to catch and handle specific exceptions that may occur during code execution.', '2023-05-23 21:29:37.368517', 'd74a7a6b-7fdd-4df0-9f67-975d160a2f36',	'4c6de959-3d0a-4e14-9a50-ef0ed8b47ed5'),
  ('748db401-ec83-4f6e-94c6-b3885e707fa2', 'Utilize the finally block to specify code that should always be executed, regardless of whether an exception was raised or not.', '2023-05-23 21:29:43.227849', 'd74a7a6b-7fdd-4df0-9f67-975d160a2f36',	'4c6de959-3d0a-4e14-9a50-ef0ed8b47ed5'),
  ('8c0093fc-107c-47a2-80fa-6d5b10161a1e', 'Implement the raise statement to explicitly raise custom exceptions when certain conditions are met, allowing for more controlled error handling.', '2023-05-23 21:29:49.877692', 'd74a7a6b-7fdd-4df0-9f67-975d160a2f36',	'4c6de959-3d0a-4e14-9a50-ef0ed8b47ed5');


INSERT INTO vote
VALUES
  ('17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', '01a7b85c-6ef8-4a32-bef9-3d345a47f5b3'),
  ('a9c69d1e-758d-4fe9-ae13-21d2df1fe118', '01a7b85c-6ef8-4a32-bef9-3d345a47f5b3'),
  ('ba9939fe-9f9d-4d5f-8a34-6e27ae986ad5', '01a7b85c-6ef8-4a32-bef9-3d345a47f5b3'),
  ('c24478ea-74b3-4ed1-93d3-8a638a0a9507', '01a7b85c-6ef8-4a32-bef9-3d345a47f5b3'),
  ('d74a7a6b-7fdd-4df0-9f67-975d160a2f36', '4b16ca9d-1bb2-4723-8fc0-1fb792216a6c'),
  ('17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', '5d26783a-8880-4e3e-84ae-55619413c82a'),
  ('c24478ea-74b3-4ed1-93d3-8a638a0a9507', '5d26783a-8880-4e3e-84ae-55619413c82a'),
  ('ba9939fe-9f9d-4d5f-8a34-6e27ae986ad5', '6e8588cb-2ab5-4b95-ab56-28c39a5d47eb'),
  ('d74a7a6b-7fdd-4df0-9f67-975d160a2f36', '748db401-ec83-4f6e-94c6-b3885e707fa2'),
  ('17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', '7feab5bc-c8d4-4df1-bcee-47807d336594'),
  ('ba9939fe-9f9d-4d5f-8a34-6e27ae986ad5', '8c0093fc-107c-47a2-80fa-6d5b10161a1e'),
  ('17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', '8c63c727-65a7-4405-a96e-2c3ab4203948'),
  ('c24478ea-74b3-4ed1-93d3-8a638a0a9507', '8c63c727-65a7-4405-a96e-2c3ab4203948'),
  ('17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', 'baff516e-7e17-4df1-9b48-8b46cc3e7034'),
  ('87db04e4-68be-4d1c-94d4-c72e4a2d5a8c', 'd1f8f36a-153f-403b-843d-69b8ae68c35f'),
  ('ba9939fe-9f9d-4d5f-8a34-6e27ae986ad5', 'd1f8f36a-153f-403b-843d-69b8ae68c35f'),
  ('ba9939fe-9f9d-4d5f-8a34-6e27ae986ad5', 'dcfb233d-8885-4b0c-aa78-de1377364e2e'),
  ('17ad9ec9-0b4f-4bfc-a8d4-c46a623bebe2', 'ed64da73-7881-417a-b9aa-2ec9f3a23e01'),
  ('87db04e4-68be-4d1c-94d4-c72e4a2d5a8c', 'ed64da73-7881-417a-b9aa-2ec9f3a23e01');