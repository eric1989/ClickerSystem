-- tables
-- Table Classes
CREATE DATABASE IF NOT EXISTS clickerSystem;
USE clickerSystem;

CREATE TABLE Class (
    Id int  NOT NULL AUTO_INCREMENT,
    Name varchar(255)  NOT NULL,
    CONSTRAINT Class_pk PRIMARY KEY (Id)
);

-- Table Enrolls
CREATE TABLE Enroll (
    Id int NOT NULL AUTO_INCREMENT,
    Student_Id int  NOT NULL,
    Class_Id int  NOT NULL,
    CONSTRAINT Enroll_pk PRIMARY KEY (Id)
);

-- Table GradeBooks
CREATE TABLE GradeBook (
    Id int NOT NULL AUTO_INCREMENT,
    Student_Id int  NOT NULL,
    Class_Id int  NOT NULL,
    QuestionNumber int  NOT NULL,
    Answer varchar(1) NOT NULL,
    IsCorrect int  NOT NULL,
    submitDate DATE NOT NULL,
    CONSTRAINT GradeBook_pk PRIMARY KEY (Id)
);

-- Table Instructors
CREATE TABLE Instructor (
    Id int  NOT NULL AUTO_INCREMENT,
    Name varchar(255)  NOT NULL,
    Password varchar(255)  NOT NULL,
    CONSTRAINT Instructors_pk PRIMARY KEY (Id)
);

-- Table Students
CREATE TABLE Student (
    Id int  NOT NULL AUTO_INCREMENT,
    Name varchar(255)  NOT NULL,
    Password varchar(255)  NOT NULL,
    CONSTRAINT Students_pk PRIMARY KEY (Id)
);

-- Table Teaches
CREATE TABLE Teacher (
	Id int NOT NULL AUTO_INCREMENT,
    Instructor_Id int  NOT NULL,
    Class_Id int  NOT NULL,
    CONSTRAINT Teacher_pk PRIMARY KEY (Id)
);

-- foreign keys
-- Reference:  Enrolls_Classes (table: Enrolls)


ALTER TABLE Enroll ADD CONSTRAINT Enroll_Class FOREIGN KEY Enroll_Class (Class_Id)
    REFERENCES Class (Id);
-- Reference:  Enrolls_Students (table: Enrolls)


ALTER TABLE Enroll ADD CONSTRAINT Enroll_Student FOREIGN KEY Enroll_Student (Student_Id)
    REFERENCES Student (Id);
-- Reference:  GradeBooks_Classes (table: GradeBooks)


ALTER TABLE GradeBook ADD CONSTRAINT GradeBook_Class FOREIGN KEY GradeBook_Class (Class_Id)
    REFERENCES Class (Id);
-- Reference:  GradeBooks_Students (table: GradeBooks)


ALTER TABLE GradeBook ADD CONSTRAINT GradeBook_Student FOREIGN KEY GradeBook_Student (Student_Id)
    REFERENCES Student (Id);
-- Reference:  Teaches_Classes (table: Teaches)


ALTER TABLE Teacher ADD CONSTRAINT Teachesr_Class FOREIGN KEY Teacher_Class (Class_Id)
    REFERENCES Class (Id);
-- Reference:  Teaches_Instructors (table: Teaches)


ALTER TABLE Teacher ADD CONSTRAINT Teacher_Instructor FOREIGN KEY Teachesr_Instructor (Instructor_Id)
    REFERENCES Instructor (Id);

-- End of file.