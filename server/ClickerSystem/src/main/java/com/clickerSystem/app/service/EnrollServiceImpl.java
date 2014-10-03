package com.clickerSystem.app.service;

import com.clickerSystem.app.dao.EnrollDAO;
import com.clickerSystem.app.model.Enroll;
import com.clickerSystem.app.model.Student;
import com.clickerSystem.app.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liqiang on 4/2/14.
 */
@Service
@Transactional
public class EnrollServiceImpl implements EnrollService {
    @Autowired
    private EnrollDAO enrollDAO;

    @Override
    public void add(Enroll e) {
        enrollDAO.addEnroll(e);
    }

    @Override
    public void delete(int eId) {
        enrollDAO.deleteEnroll(eId);
    }

    @Override
    public Enroll get(int eId) {
        return enrollDAO.getEnroll(eId);
    }

    @Override
    public List<Enroll> getEnrollsByStudent(Student s) {
        return enrollDAO.getEnrollsByStudent(s);
    }

    @Override
    public boolean isStudentEnrollInClass(Student s, Class c) {
        List<Enroll> enrolls = getEnrollsByStudent(s);
        for (Enroll each : enrolls) {
            if (each.getClass1().equals(c)) {
                 return true;
            }
        }
        return false;
    }
}
