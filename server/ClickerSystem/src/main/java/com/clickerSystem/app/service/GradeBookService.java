package com.clickerSystem.app.service;

import com.clickerSystem.app.model.GradeBook;

import java.util.List;

/**
 * Created by liqiang on 3/29/14.
 */
public interface GradeBookService {
    public void addGB(GradeBook c);
    public void updateGB(GradeBook g, String Answer);
    public GradeBook getGB(int id);
    public void deleteGB(int id);
    public void deleteGB(int classId, int questionNumber);
    public int hasGB(GradeBook g);
    public List<GradeBook> getGBs();
    public List<GradeBook> getCurrentGBs(int classId);
}
