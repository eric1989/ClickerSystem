package com.clickerSystem.app.service;

import javax.persistence.Tuple;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liqiang on 3/29/14.
 */

public class TeacherSettingService {
    private static Map<Integer,Answer> dic = new HashMap<Integer, Answer>();

    public static int getQuestionNumber(int classId){
        if(dic.containsKey(classId)) {
            return dic.get(classId).questionNumber;
        }
        return -1;
    }

    public static String getCorrectAnswer(int classId) {
        return dic.get(classId).answer;
    }

    public static void addAnswer(String answer, int questionNumber, int classId) {
        try {
            Answer a = new Answer(answer, questionNumber);
            dic.put(classId,a);
        }catch (Exception e) {
            System.out.println("teacher Setting add answer error");
        }
    }
}

class Answer {
    int questionNumber;
    String answer;
    public Answer(String answer, int questionNumber) {
        this.answer = answer;
        this.questionNumber = questionNumber;
    }
}

