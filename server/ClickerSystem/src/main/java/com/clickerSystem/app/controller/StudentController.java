package com.clickerSystem.app.controller;

import com.clickerSystem.app.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clickerSystem.app.model.Student;
import com.clickerSystem.app.service.StudentService;

import java.util.List;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/add")
	public @ResponseBody String studentAdd(
			@RequestParam(value="name", required=true) String name,
            @RequestParam(value="password", required=true) String password) {
		Student c = new Student();
		c.setName(name);
		c.setPassword(password);
		studentService.addStudent(c);
		System.out.println(c.getName());
        return "success";
    }

	@RequestMapping(value = "/get")
	public @ResponseBody Student studentGet(
			@RequestParam(value="Id", required = true) String Id) {
		return studentService.getStudent(Integer.parseInt(Id));
	}

	@RequestMapping(value = "/update")
	public @ResponseBody String studentUpdate(
			@RequestParam(value = "Id", required = true) String Id,
			@RequestParam(value = "Name", required = true) String Name,
			@RequestParam(value = "Password", required = true) String Password) {
		Student c = studentService.getStudent(Integer.parseInt(Id));
		studentService.updateStudent(c, Name, Password);
		return "success";
	}

	@RequestMapping(value = "/remove")
	public @ResponseBody String studentDelete(
			@RequestParam(value = "Id", required = true) String Id) {
		studentService.deleteStudent(Integer.parseInt(Id));
		return "success";
	}

	@RequestMapping(value = "/getStudents")
	public @ResponseBody List<Student> studentGetAllStudents() {
		return studentService.getStudents();
	}

	@RequestMapping(value = "/login")
	public @ResponseBody String studentLogin(
			@RequestParam(value = "Name", required = true) String Name,
			@RequestParam(value = "Password", required = true) String Password) {

		for (Student s : studentService.getStudents()) {
			if (s.getName().equals(Name) && s.getPassword().equals(Password)) {
				return s.getId().toString();
			}
		}

		return "-1";
	}
}
