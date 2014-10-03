package com.clickerSystem.app.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.clickerSystem.app.model.GradeBook;
import com.clickerSystem.app.service.GradeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clickerSystem.app.model.Greeting;

@Controller
public class GreetingController {
    @Autowired
    private GradeBookService gradeBookService;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public @ResponseBody Greeting greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    @RequestMapping("/gradeBook")
    public @ResponseBody List<GradeBook> gradeBookList(
            @RequestParam(value="classId") int classId){
        return gradeBookService.getCurrentGBs(classId);
    }
}