package com.clickerSystem.app.controller;

import com.clickerSystem.app.model.AnalysisResult;
import com.clickerSystem.app.service.AnswerAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liqiang on 4/2/14.
 */
@Controller
public class ResultAnalysisController {
    @Autowired
    private AnswerAnalysis aa;

    @RequestMapping("/getAnalysis")
    public @ResponseBody List<AnalysisResult> getAnalysis(@RequestParam(value="classId",required=true) int classId) {
        return aa.getAnalysisResults(classId);
    }
}
