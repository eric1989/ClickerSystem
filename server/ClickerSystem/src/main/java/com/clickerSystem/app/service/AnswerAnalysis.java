package com.clickerSystem.app.service;

import com.clickerSystem.app.model.AnalysisResult;

import java.util.List;

/**
 * Created by liqiang on 4/2/14.
 */
public interface AnswerAnalysis {
    public List<AnalysisResult> getAnalysisResults(int classId);
}
