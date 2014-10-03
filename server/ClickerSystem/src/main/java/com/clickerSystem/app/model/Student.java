package com.clickerSystem.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")

public class Student {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id;

	private String name;

	private String password;

	public Student() {
	}

	public Student(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId(){
		return this.id;
	}

	public void setId(int id){
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
