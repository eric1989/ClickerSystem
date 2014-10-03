package com.clickerSystem.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Class")

public class Class {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id;

	private String name;

	public Class() {
	}

	public Class(int id, String name) {
		this.id = id;
		this.name = name;
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

    @Override
    public boolean equals(Object o) {
        Class b = (Class) o;
        if (b.getId() == this.getId()) {
            return true;
        }
        return false;
    }
}
