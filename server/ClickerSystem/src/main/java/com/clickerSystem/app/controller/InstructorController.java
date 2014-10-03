package com.clickerSystem.app.controller;

import com.clickerSystem.app.service.InstructorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clickerSystem.app.model.Instructor;
import com.clickerSystem.app.service.InstructorService;

import java.util.List;

@Controller
@RequestMapping(value="/instructor")
public class InstructorController {

	@Autowired
	private InstructorService InstructorService;

	@RequestMapping(value="/add")
	public @ResponseBody String InstructorAdd(
			@RequestParam(value="name", required=true) String name,
			@RequestParam(value="password", required=true) String password) {
		Instructor c = new Instructor();
		c.setName(name);
		c.setPassword(password);
		InstructorService.addInstructor(c);
		System.out.println(c.getName());
		return "success";
	}

	@RequestMapping(value = "/get")
	public @ResponseBody Instructor InstructorGet(
			@RequestParam(value="Id", required = true) String Id) {
		return InstructorService.getInstructor(Integer.parseInt(Id));
	}

	@RequestMapping(value = "/update")
	public @ResponseBody String InstructorUpdate(
			@RequestParam(value = "Id", required = true) String Id,
			@RequestParam(value = "Name", required = true) String Name,
			@RequestParam(value = "Password", required = true) String Password) {
		Instructor c = InstructorService.getInstructor(Integer.parseInt(Id));
		InstructorService.updateInstructor(c, Name, Password);
		return "success";
	}

	@RequestMapping(value = "/remove")
	public @ResponseBody String InstructorDelete(
			@RequestParam(value = "Id", required = true) String Id) {
		InstructorService.deleteInstructor(Integer.parseInt(Id));
		return "success";
	}

	@RequestMapping(value = "/getInstructors")
	public @ResponseBody List<Instructor> InstructorGetAllInstructors() {
		return InstructorService.getInstructors();
	}

	@RequestMapping(value = "/login")
	public @ResponseBody String instructorLogin(
			@RequestParam(value = "Name", required = true) String Name,
			@RequestParam(value = "Password", required = true) String Password) {

		for (Instructor i : InstructorService.getInstructors()) {
			if (i.getName().equals(Name) && i.getPassword().equals(Password)) {
				return i.getId().toString();
			}
		}

		return "-1";
	}
}
