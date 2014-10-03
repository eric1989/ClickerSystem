package com.clickerSystem.app.dao;

import java.util.List;
import com.clickerSystem.app.model.Class;

public interface ClassDAO {
	
	public void addClass(Class c);
	public void updateClass(Class c, String name);
	public Class getClass(int id);
	public void deleteClass(int id);
	public List<Class> getClasses();
}
