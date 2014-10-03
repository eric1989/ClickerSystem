package com.clickerSystem.app.dao;

import com.clickerSystem.app.model.GradeBook;

import java.util.List;

/**
 * Created by liqiang on 3/29/14.
 */
public interface GradeBookDAO {
    public void addGB(GradeBook c);
    public void updateGB(GradeBook g, String Answer);
    public GradeBook getGB(int id);
    public void deleteGB(int id);
    public void deleteGB(int classId, int questionNumber);
    public List<GradeBook> getGBs();
    public int hasGB(GradeBook g);
    public List<GradeBook> getCurrentGBs(int classId);
}
