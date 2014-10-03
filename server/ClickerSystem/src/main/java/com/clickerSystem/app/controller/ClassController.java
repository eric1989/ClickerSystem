package com.clickerSystem.app.controller;

import com.clickerSystem.app.model.Instructor;
import com.clickerSystem.app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clickerSystem.app.model.Class;
import com.clickerSystem.app.service.ClassService;

import java.util.List;

@Controller
@RequestMapping(value="/class")
public class ClassController {
	
	@Autowired
	private ClassService classService;
	
	@RequestMapping(value="/add")
	public @ResponseBody String classAdd(
            @RequestParam(value="name", required=true) String name) {
		Class c = new Class();
		c.setName(name);
		classService.addClass(c);
		System.out.println(c.getName());
        return "success";
    }

	@RequestMapping(value = "/get")
	public @ResponseBody Class classGet(
			@RequestParam(value="Id", required = true) String Id) {
		return classService.getClass(Integer.parseInt(Id));
	}

	@RequestMapping(value = "/update")
	public @ResponseBody String classUpdate(
			@RequestParam(value = "Id", required = true) String Id,
			@RequestParam(value = "Name", required = true) String Name) {
		Class c = classService.getClass(Integer.parseInt(Id));
		classService.updateClass(c, Name);
		return "success";
	}

	@RequestMapping(value = "/remove")
	public @ResponseBody String classDelete(
			@RequestParam(value = "Id", required = true) String Id) {
		classService.deleteClass(Integer.parseInt(Id));
		return "success";
	}

	@RequestMapping(value = "/getClasses")
	public @ResponseBody List<Class> classGetAllClasses() {
		return classService.getClasses();
	}

    @RequestMapping(value = "/getClassesById")
    public @ResponseBody List<Class> getClassesByStudent(@RequestParam(value="Id", required = true) int id,
                                                         @RequestParam(value ="caller", required = true) String caller) {
        if (caller.equalsIgnoreCase("student")) {
            Student s = new Student();
            s.setId(id);
            return classService.getClassesByStudent(s);
        }
        else if(caller.equalsIgnoreCase("instructor")) {
            Instructor i = new Instructor();
            i.setId(id);
            return classService.getClassesByInstructor(i);
        }
        return null;
    }
}
