USE clickerSystem;
INSERT INTO Class (Name) VALUE("CSCI-1901");
INSERT INTO Class (Name) VALUE("CSCI-1902");
INSERT INTO Class (Name) VALUE("CSCI-2033");
INSERT INTO Class (Name) VALUE("CSCI-4061");
INSERT INTO Class (Name) VALUE("CSCI-4511w");
INSERT INTO Student (Name,Password) VALUES("Eric","12345");
INSERT INTO Student (Name,Password) VALUES("Rick","23456");
INSERT INTO Student (Name,Password) VALUES("Tom","34567");
INSERT INTO Student (Name,Password) VALUES("Sun","45678");
INSERT INTO Student (Name,Password) VALUES("Zhou","56789");
INSERT INTO Instructor (Name,Password) VALUES("Zhang","12345");
INSERT INTO Instructor (Name,Password) VALUES("Zhi-Li","23456");
INSERT INTO Instructor (Name,Password) VALUES("John","34567");
INSERT INTO Instructor (Name,Password) VALUES("Jordan","45678");
INSERT INTO Instructor (Name,Password) VALUES("Mike","56789");
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(1,1);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(1,2);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(1,3);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(1,4);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(1,5);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(2,1);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(2,2);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(2,3);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(2,4);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(3,1);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(3,2);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(3,3);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(4,1);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(4,2);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(5,1);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(5,2);
INSERT INTO Enroll (Student_Id,Class_Id) VALUES(5,3);
INSERT INTO Teacher (Instructor_Id,Class_Id) VALUES(1,1);
INSERT INTO Teacher (Instructor_Id,Class_Id) VALUES(2,2);
INSERT INTO Teacher (Instructor_Id,Class_Id) VALUES(3,3);
INSERT INTO Teacher (Instructor_Id,Class_Id) VALUES(4,4);
INSERT INTO Teacher (Instructor_Id,Class_Id) VALUES(5,5);