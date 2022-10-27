package com.example.course_work_2.interFace;

import com.example.course_work_2.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
