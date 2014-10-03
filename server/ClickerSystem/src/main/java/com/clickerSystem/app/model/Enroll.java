package com.clickerSystem.app.model;

import javax.persistence.*;
import com.clickerSystem.app.model.Class;

/**
 * Created by liqiang on 4/1/14.
 */
@Entity
@Table(name="Enroll")
public class Enroll {
    @Id
    @Column
    private int Id;
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "Id",nullable = false)
    private Class class1;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "Id", nullable = false)
    private Student student;

    public Enroll() {
    }

    public Enroll(Class c, Student s) {
         this.class1 = c;
         this.student = s;
    }

    public Class getClass1() {
        return this.class1;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setClass1(Class c) {
        this.class1 = c;
    }

    public void setStudent(Student s) {
        this.student = s;
    }
}
