package com.clickerSystem.app.dao;

import java.util.List;
import com.clickerSystem.app.model.Student;

public interface StudentDAO {
    public void addStudent(Student s);
    public void updateStudent(Student s, String name, String password);
    public Student getStudent(int id);
    public void deleteStudent(int id);
    public List<Student> getStudents();
}
