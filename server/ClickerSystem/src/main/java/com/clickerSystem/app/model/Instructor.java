package com.clickerSystem.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Instructor")
public class Instructor {

	private int id;
	private String name;
	private String password;

	public Instructor() {
	}

	public Instructor(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	@Id
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId(){
		return this.id;
	}

	public void setId(int id){
		this.id = id;
	}

	@Column(name = "Name", nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Password", nullable = false, length = 100)
	public String getPassword() {
		return password;
	}

	public void setPassword(String pwd) {
		this.password = pwd;
	}
}
