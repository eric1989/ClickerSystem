package com.clickerSystem.app.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by liqiang on 3/29/14.
 */
@Entity
@Table(name="GradeBook")
public class GradeBook {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "Id",nullable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "Id", nullable = false)
    private Class class1;
    @Column(name = "questionNumber")
    private int questionNumber;
    @Column(name = "Answer")
    private String answer;
    @Column(name = "isCorrect")
    private int isCorrect;
    @Column(name = "submitDate")
    private Date submitDate;

    public GradeBook(){};
    public GradeBook(int id, Student student, Class class1, int questionNumber, String answer, int isCorrect, Date submitDate) {
        this.id = id;
        this.student = student;
        this.class1 = class1;
        this.questionNumber = questionNumber;
        this.answer = answer;
        this.isCorrect = isCorrect;
        this.submitDate = submitDate;
    }


    public int getId(){
        return this.id;
    }
    public Student getStudent() {
        return this.student;
    }
    public Class getClass1() {
        return this.class1;
    }

    public int getQuestionNumber() {
        return this.questionNumber;
    }
    public String getAnswer() {return this.answer;}
    public int getIsCorrect() {
        return this.isCorrect;
    }
    public Date getSubmitDate() {return this.submitDate;}

    public void setId(int id) {this.id = id;}
    public void setStudent (Student student){ this.student = student;}
    public void setClass (Class class1) {this.class1 = class1;}
    public void setQuestionNumber(int questionNumber){ this.questionNumber = questionNumber;}
    public void setAnswer(String a) {this.answer=a;}
    public void setIsCorrect(int isCorrect){ this.isCorrect = isCorrect;}
    public void setSubmitDate(Date submitDate) {this.submitDate = submitDate;}
}
