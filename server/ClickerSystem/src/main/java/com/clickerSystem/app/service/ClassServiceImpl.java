package com.clickerSystem.app.service;

import java.util.ArrayList;
import java.util.List;

import com.clickerSystem.app.dao.TeacherDAO;
import com.clickerSystem.app.model.*;
import com.clickerSystem.app.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clickerSystem.app.dao.ClassDAO;

@Service
@Transactional
public class ClassServiceImpl implements ClassService{
	@Autowired
	private ClassDAO classDAO;
    @Autowired
	private EnrollService enrollService;
    @Autowired
    private TeacherDAO teacherDAO;

	public void addClass(Class c){
		classDAO.addClass(c);
	}
	public void updateClass(Class c, String name){
		classDAO.updateClass(c, name);
	}
	public Class getClass(int id){
		return classDAO.getClass(id);
	}
	public void deleteClass(int id){
		classDAO.deleteClass(id);
	}
	public List<Class> getClasses(){
		return classDAO.getClasses();
	}

    public List<Class> getClassesByStudent(Student s) {
        List<Enroll> enrolls = enrollService.getEnrollsByStudent(s);
        List<Class> res = new ArrayList<Class>();
        for(Enroll each : enrolls) {
            res.add(each.getClass1());
        }
        return res;
    }

    public List<Class> getClassesByInstructor(Instructor i) {
        List<Teacher> teachers = teacherDAO.getTeachersByInstructor(i);
        List<Class> res = new ArrayList<Class>();
        for(Teacher each : teachers) {
            res.add(each.getClass1());
        }
        return res;
    }
}
