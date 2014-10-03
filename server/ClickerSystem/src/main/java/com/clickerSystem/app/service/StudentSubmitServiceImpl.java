package com.clickerSystem.app.service;

import com.clickerSystem.app.model.Enroll;
import com.clickerSystem.app.model.Class;
import com.clickerSystem.app.model.GradeBook;
import com.clickerSystem.app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

/**
 * Created by liqiang on 3/29/14.
 */

@Service
@Transactional
public class StudentSubmitServiceImpl implements StudentSubmitService{
    @Autowired
    private GradeBookService gb;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService  classService;
    @Autowired
    private EnrollService enrollService;

    public void addGradeBook(int classId, int studentId, String answer) {
        if (!isEnrolled(classId,studentId)) {
            System.out.println("Student not enrolled in this Class");
            return;
        }
        int currentQuestionNumber = TeacherSettingService.getQuestionNumber(classId);
        String currentAnswer = TeacherSettingService.getCorrectAnswer(classId);

        int isCorrect = isCorrect(answer,currentAnswer);
        GradeBook record = new GradeBook();
        record.setStudent(studentService.getStudent(studentId));
        record.setClass(classService.getClass(classId));
        record.setQuestionNumber(currentQuestionNumber);
        record.setIsCorrect(isCorrect);
        record.setAnswer(answer);
        record.setSubmitDate(new Date(new java.util.Date().getTime()));
        int hasId  = gb.hasGB(record);
        if ( hasId > 0 ) {
            record.setId(hasId);
            System.out.println("Update");
            gb.updateGB(record,answer);
        }
        else {
            gb.addGB(record);
        }
    }

    private int isCorrect(String sAnswer, String cAnswer) {
        if (sAnswer.equalsIgnoreCase(cAnswer)) {
            return 1;
        }
        return 0;
    }

    private boolean isEnrolled(int classId, int studentId) {
        Class c = new Class();
        c.setId(classId);
        Student s = new Student();
        s.setId(studentId);
        return enrollService.isStudentEnrollInClass(s,c);
    }
}
