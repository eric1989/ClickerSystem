package com.clickerSystem.app.service;

import com.clickerSystem.app.model.AnalysisResult;
import com.clickerSystem.app.model.GradeBook;
import com.clickerSystem.app.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiang on 4/2/14.
 */
@Service
public class AnswerAnalysisImpl implements AnswerAnalysis {
    @Autowired
    private GradeBookService gradeBookService;

    @Override
    public List<AnalysisResult> getAnalysisResults(int classId) {
          List<AnalysisResult> results = new ArrayList<AnalysisResult>();
          List<GradeBook> gbSet = gradeBookService.getCurrentGBs(classId);
          int totalStudents = gbSet.size();
          int questionNumber = TeacherSettingService.getQuestionNumber(classId);
          for(Answer a : Answer.values()) {
               AnalysisResult ar = new AnalysisResult();
               ar.setAnswer(a);
               int number = 0;
               for(GradeBook gb : gbSet) {
                     if (gb.getQuestionNumber() == questionNumber &&gb.getAnswer().toString().equals(a.toString())) {
                         number++;
                     }
               }
               ar.setPercentage((float)number/(float)totalStudents);
               results.add(ar);
          }
          return results;
    }
}
