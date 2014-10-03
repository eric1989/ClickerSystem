package com.clickerSystem.app.model;

/**
 * Created by liqiang on 4/2/14.
 */
public class AnalysisResult {
    private Answer answer;
    private float  percentage;

    public AnalysisResult(Answer answer, float percentage) {
        this.answer = answer;
        this.percentage = percentage;
    }
    public AnalysisResult(){}
    public Answer getAnswer() {return this.answer;}
    public float  getPercentage() {return this.percentage;}

    public void setAnswer(Answer answer){ this.answer = answer;}
    public void setPercentage(float percentage) {this.percentage = percentage;}
}
