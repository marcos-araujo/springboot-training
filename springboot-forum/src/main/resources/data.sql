INSERT INTO USER(name, email, password)
VALUES('Student', 'student@email.com', '$2a$10$KLLwUfQoLK80Vzfx0xUe1uBllT7nVN548ox2FMGkoKmQQ9z/Ziffy');
INSERT INTO USER(name, email, password)
VALUES('Moderator', 'moderator@email.com', '$2a$10$KLLwUfQoLK80Vzfx0xUe1uBllT7nVN548ox2FMGkoKmQQ9z/Ziffy');

INSERT INTO AUTHORITY(id, name) VALUES(1, 'ROLE_STUDENT');
INSERT INTO AUTHORITY(id, name) VALUES(2, 'ROLE_MODERATOR');

INSERT INTO USER_AUTHORITIES(user_id, authorities_id) VALUES(1, 1);
INSERT INTO USER_AUTHORITIES(user_id, authorities_id) VALUES(2, 2);

INSERT INTO COURSE(name, category) VALUES('Spring Boot', 'Back-End Development');
INSERT INTO COURSE(name, category) VALUES('HTML 5', 'Front-end');

INSERT INTO THREAD(title, message, creation_date, status, author_id, course_id)
VALUES('Problem', 'Error creating project', '2019-05-05 18:00:00', 'NOT_ANSWERED', 1, 1);

INSERT INTO THREAD(title, message, creation_date, status, author_id, course_id)
VALUES('Problem 2', 'Compilation problem', '2019-05-05 19:00:00', 'NOT_ANSWERED', 1, 1);

INSERT INTO THREAD(title, message, creation_date, status, author_id, course_id)
VALUES('Problem 3', 'HTML Tag', '2019-05-05 20:00:00', 'NOT_ANSWERED', 1, 2);