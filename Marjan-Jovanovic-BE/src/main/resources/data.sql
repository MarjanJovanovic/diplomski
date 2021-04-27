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
-- INSERT INTO professor(firstName, lastName, email, address, postal_code, phone, reelectionDate, title_id) VALUES


-- Table initialization: Professor-Subject


-- Table initialization: ExamEntity Period

-- Table initialization: ExamEntity





