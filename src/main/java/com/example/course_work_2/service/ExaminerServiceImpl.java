package com.example.course_work_2.service;

import com.example.course_work_2.exeption.NumberOfQuestionIsNotPresentException;
import com.example.course_work_2.interFace.ExaminerService;
import com.example.course_work_2.interFace.QuestionService;
import com.example.course_work_2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {

        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new NumberOfQuestionIsNotPresentException();
        }
        Set<Question> tempSet = new HashSet<>();
        int count = 0;
        Question tempQuestion;
        while (count < amount) {
            tempQuestion = questionService.getRandomQuestion();
            if (!tempSet.contains(tempQuestion)) {
                tempSet.add(tempQuestion);
                count++;
            }
        }
        return tempSet;
    }
}
