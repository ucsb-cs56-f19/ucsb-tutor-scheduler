INSERT INTO course_offering (course,quarter,instructor) VALUES ('CMPSC 16','F19','Mirza');
INSERT INTO course_offering (course,quarter,instructor) VALUES ('CMPSC 160','F19','Ding');
INSERT INTO course_offering (course,quarter,instructor) VALUES ('CMPSC 130A','W20','Koc');
INSERT INTO course_offering (course,quarter,instructor) VALUES ('CMPSC 130B','W20','Lokshtanov');
<<<<<<< HEAD
INSERT INTO tutor (fname,lname,email) VALUES ('Scott','Chow','scottpchow@example.org');
INSERT INTO tutor (fname,lname,email) VALUES ('Zach','Sisco','zachsisco@example.org');
INSERT INTO tutor (fname,lname,email) VALUES ('Yinon','Rousso','yinonRousso@example.org');
INSERT INTO tutor (fname,lname,email) VALUES ('Kate','Perkins','kateperkins@example.org');
INSERT INTO tutor (fname,lname,email) VALUES ('George','Kripac','Georgekripac@example.org');
INSERT INTO tutor_assignment (course_offering_id,tutor_id) VALUES (1,1);
=======
INSERT INTO tutor (fname,lname,email,level) VALUES ('Scott','Chow','scottpchow@example.org','PAID');
INSERT INTO tutor (fname,lname,email,level) VALUES ('Zach','Sisco','zachsisco@example.org','PAID');
INSERT INTO tutor (fname,lname,email,level) VALUES ('Yinon','Rousso','yinonRousso@example.org','190J');
INSERT INTO tutor (fname,lname,email,level) VALUES ('Kate','Perkins','kateperkins@example.org','190J');
INSERT INTO tutor (fname,lname,email,level) VALUES ('George','Kripac','Georgekripac@example.org','190J');
INSERT INTO tutor_assignment (course_offering_id,tutor_id) VALUES (1,1);
INSERT INTO tutor_assignment (course_offering_id,tutor_id) VALUES (2,2);
INSERT INTO tutor_assignment (course_offering_id,tutor_id) VALUES (3,3);
INSERT INTO tutor_assignment (course_offering_id,tutor_id) VALUES (4,4);
>>>>>>> AS/KK added data.sql for local testing, form successfully filters tutor assignments
