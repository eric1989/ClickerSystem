package com.clickerSystem.app.dao;

import com.clickerSystem.app.model.Enroll;
import com.clickerSystem.app.model.Student;

import java.util.List;

/**
 * Created by liqiang on 4/1/14.
 */
public interface EnrollDAO {
    public void addEnroll(Enroll e);
    public void deleteEnroll(int enrollId);
    public Enroll getEnroll(int enrollId);
    public List<Enroll> getEnrollsByStudent(Student s);
}
