package com.clickerSystem.app.controller;

import com.clickerSystem.app.service.StudentSubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liqiang on 3/29/14.
 */
@Controller
@RequestMapping(value="/studentSubmit")
public class StudentSubmitController {
       @Autowired
       private StudentSubmitService sss;

       @RequestMapping("/submit")
       public @ResponseBody String submit(
                                          @RequestParam(value ="classId", required = true) int classId,
                                          @RequestParam(value="studentId", required = true) int studentId,
                                          @RequestParam(value="answer", required = true) String answer) {
           sss.addGradeBook(classId, studentId,answer);
           return "success";
       }
}
