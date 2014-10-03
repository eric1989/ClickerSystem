package com.clickerSystem.app.model;

import javax.persistence.*;
import com.clickerSystem.app.model.Class;

@Entity
@Table(name="Teacher")
public class Teacher {
	@Id
	@Column
	private int Id;
	@ManyToOne
	@JoinColumn(name = "Class_Id", referencedColumnName = "Id",nullable = false)
	private Class class1;
	@ManyToOne
	@JoinColumn(name = "Instructor_Id", referencedColumnName = "Id", nullable = false)
	private Instructor instructor;

	public Teacher() {
	}

	public Teacher(Class c, Instructor i) {
		this.class1 = c;
		this.instructor = i;
	}

	public Class getClass1() {
		return this.class1;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}

	public void setClass1(Class c) {
		this.class1 = c;
	}

	public void setSInstructor(Instructor i) {
		this.instructor = i;
	}
}
