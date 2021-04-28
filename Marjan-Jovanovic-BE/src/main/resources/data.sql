-- Table initialization: City
INSERT INTO city VALUES(11000,"Beograd");
INSERT INTO city VALUES(13000,"Pancevo");
INSERT INTO city VALUES(16000,"Leskovac");
INSERT INTO city VALUES(18000,"Nis");
INSERT INTO city VALUES(37230,"Aleksandrovac");

-- Table initialization: Title
INSERT INTO title(title) VALUES ("Teaching_assistant");
INSERT INTO title(title) VALUES ("Assistant_Professor");
INSERT INTO title(title) VALUES ("Associate_professor");
INSERT INTO title(title) VALUES ("Professor");

-- Table initialization: Subject
INSERT INTO subject(name, description, no_of_esp, year_of_study, semester) VALUES ("Subject 1", "Description 1", 5, 1, "Summer");
INSERT INTO subject(name, description, no_of_esp, year_of_study, semester) VALUES ("Subject 2", "Description 2", 7, 1, "Summer");
INSERT INTO subject(name, description, no_of_esp, year_of_study, semester) VALUES ("Subject 3", "Description 3", 6, 2, "Winter");
INSERT INTO subject(name, description, no_of_esp, year_of_study, semester) VALUES ("Subject 4", "Description 4", 8, 2, "Winter");

-- Table initialization: Student
INSERT INTO student(first_name, last_name, email, address, postal_code, index_number, index_year, current_year_of_study) VALUES ("Studentko 1", "Studentkovic 1", "student1@student.com", "Student address 1", 11000, "1001", "2001", 1);
INSERT INTO student(first_name, last_name, email, address, postal_code, index_number, index_year, current_year_of_study) VALUES ("Studentko 2", "Studentkovic 2", "student2@student.com", "Student address 2", 11000, "1002", "2002", 1);
INSERT INTO student(first_name, last_name, email, address, postal_code, index_number, index_year, current_year_of_study) VALUES ("Studentko 3", "Studentkovic 3", "student3@student.com", "Student address 3", 18000, "1003", "2003", 1);
INSERT INTO student(first_name, last_name, email, address, postal_code, index_number, index_year, current_year_of_study) VALUES ("Studentko 4", "Studentkovic 4", "student4@student.com", "Student address 4", 18000, "1004", "2004", 2);
INSERT INTO student(first_name, last_name, email, address, postal_code, index_number, index_year, current_year_of_study) VALUES ("Studentko 5", "Studentkovic 5", "student5@student.com", "Student address 5", 16000, "1005", "2005", 2);
INSERT INTO student(first_name, last_name, email, address, postal_code, index_number, index_year, current_year_of_study) VALUES ("Studentko 6", "Studentkovic 6", "student6@student.com", "Student address 6", 16000, "1006", "2006", 2);

-- Table initialization: Professor
INSERT INTO professor(first_name, last_name, email, address, postal_code, phone, reelection_date, title_id) VALUES ("Profesor 1", "Profesorovic 1", "profesor1@profesor.com", "Profesor adresa 1", 11000, 123456789, CURDATE(), 1);
INSERT INTO professor(first_name, last_name, email, address, postal_code, phone, reelection_date, title_id) VALUES ("Profesor 2", "Profesorovic 2", "profesor2@profesor.com", "Profesor adresa 2", 16000, 234567891, CURDATE(), 2);
INSERT INTO professor(first_name, last_name, email, address, postal_code, phone, reelection_date, title_id) VALUES ("Profesor 3", "Profesorovic 3", "profesor3@profesor.com", "Profesor adresa 3", 18000, 345678912, CURDATE(), 3);
INSERT INTO professor(first_name, last_name, email, address, postal_code, phone, reelection_date, title_id) VALUES ("Profesor 4", "Profesorovic 4", "profesor4@profesor.com", "Profesor adresa 4", 13000, 456789123, CURDATE(), 4);

-- Table initialization: Professor-Subject
INSERT INTO subject_professor(subject_id, professor_id) VALUES (4, 1);
INSERT INTO subject_professor(subject_id, professor_id) VALUES (4, 2);
INSERT INTO subject_professor(subject_id, professor_id) VALUES (3, 3);

-- Table initialization: ExamPeriod Entity
INSERT INTO exam_period(name, start_date, end_date, is_active) VALUES ("Januarski", "2021-01-01", "2021-01-10", 1);
INSERT INTO exam_period(name, start_date, end_date, is_active) VALUES ("Aprilski", "2021-04-01", "2021-04-15", 0);
INSERT INTO exam_period(name, start_date, end_date, is_active) VALUES ("Junski", "2021-06-01", "2021-01-20", 0);

-- Table initialization: ExamEntity
INSERT INTO exam(exam_period_entity_id, date, professor_id, subject_id) VALUES (1, "2021-01-05", 2, 4);
INSERT INTO exam(exam_period_entity_id, date, professor_id, subject_id) VALUES (1, "2021-01-07", 1, 4);

-- Table initialization: Student_Exam
INSERT INTO student_exam(exam_id, student_id) VALUES (1, 1);
INSERT INTO student_exam(exam_id, student_id) VALUES (1, 2);







