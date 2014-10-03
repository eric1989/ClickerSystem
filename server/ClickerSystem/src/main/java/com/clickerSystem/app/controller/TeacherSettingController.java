package com.clickerSystem.app.controller;

import com.clickerSystem.app.service.TeacherSettingService;
import com.clickerSystem.app.service.GradeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liqiang on 3/29/14.
 */

@Controller
public class TeacherSettingController {
	@Autowired
	private GradeBookService gradeBookService;

    @RequestMapping(value="/teacherSet")
    public @ResponseBody String setTeacherSetting(
                                  @RequestParam(value ="classId", required = true) int classId,
                                  @RequestParam(value="number", required = true) int number,
                                  @RequestParam(value = "answer", required = true) String answer) {
    	int currentQNumber = TeacherSettingService.getQuestionNumber(classId);
    	if (currentQNumber == number) {
    		gradeBookService.deleteGB(classId,number);
    	}
        TeacherSettingService.addAnswer(answer,number,classId);
        return "success";
    }
}
