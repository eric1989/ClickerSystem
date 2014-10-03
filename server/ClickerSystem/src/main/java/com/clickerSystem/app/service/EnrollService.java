package com.clickerSystem.app.service;

import com.clickerSystem.app.model.Enroll;
import com.clickerSystem.app.model.Student;
import com.clickerSystem.app.model.Class;

import java.util.List;

/**
 * Created by liqiang on 4/2/14.
 */
public interface EnrollService {
    public void add(Enroll e);
    public void delete(int eId);
    public Enroll get(int eId);
    public List<Enroll> getEnrollsByStudent(Student s);
    public boolean isStudentEnrollInClass(Student s, Class c);
}
