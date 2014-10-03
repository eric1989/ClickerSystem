package com.clickerSystem.app.service;

import com.clickerSystem.app.dao.GradeBookDAO;
import com.clickerSystem.app.model.GradeBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liqiang on 3/29/14.
 */
@Service
@Transactional
public class GradeBookServiceImpl implements GradeBookService {
    @Autowired
    private GradeBookDAO gbDAO;

    public void addGB(GradeBook gb) {
         gbDAO.addGB(gb);
    }

    public void updateGB(GradeBook gb, String answer) {
        gbDAO.updateGB(gb,answer);
    }

    public GradeBook getGB(int id) {
        return gbDAO.getGB(id);
    }

    public void deleteGB(int id) {
        gbDAO.deleteGB(id);
    }

    public void deleteGB(int classId, int questionNumber) {
        gbDAO.deleteGB(classId,questionNumber);
    }

    public int hasGB(GradeBook g) {
        return gbDAO.hasGB(g);
    }
    public List<GradeBook> getGBs() {
        return gbDAO.getGBs();
    }
    public List<GradeBook> getCurrentGBs(int classId) {
        return gbDAO.getCurrentGBs(classId);
    }

}
