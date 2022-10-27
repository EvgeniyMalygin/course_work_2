package com.example.course_work_2.service;

import com.example.course_work_2.exeption.QuestionIsNotFoundException;
import com.example.course_work_2.interFace.QuestionService;
import com.example.course_work_2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set <Question> questionSet = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question tempQuestion = new Question(question, answer);
        questionSet.add(tempQuestion);
        return tempQuestion;
    }

    @Override
    public Question add(Question question) {
        questionSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if(!questionSet.contains(question)){
            throw new QuestionIsNotFoundException();
        }
        questionSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questionSet);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        return questionSet.stream().skip(random.nextInt(questionSet.size())).findFirst().orElse(null);
    }

}
