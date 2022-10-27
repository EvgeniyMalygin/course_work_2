package com.example.course_work_2.service;

import com.example.course_work_2.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;


    @Test
    void getQuestionsCorrectAmount() {
        int amount = 2;
        Question question1 = new Question( "Как обозначается элементарный тип целых чисел?", "int");
        Question question4 = new Question("Какие типы данных существуют в java?", "byte, short, long," +
                " int, long, double, char, string");
        Set<Question> temp = new HashSet<>();
                temp.add(question1);
                temp.add(question4);
        when(questionService.getRandomQuestion()).thenReturn(question1, question4);
        when(questionService.getAll()).thenReturn(temp);
        Assertions.assertThat(examinerService.getQuestions(amount))
                .isEqualTo(temp);
    }
}