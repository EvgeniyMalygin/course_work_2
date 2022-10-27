package com.example.course_work_2.service;

import com.example.course_work_2.exeption.QuestionIsNotFoundException;
import com.example.course_work_2.model.Question;
import com.example.course_work_2.service.JavaQuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionServiceTest() {
        this.javaQuestionService = new JavaQuestionService();
    }

    @Test
    void addCorrectDataString() {
        Assertions.assertThat(javaQuestionService.getAll())
                        .isEmpty();
        Assertions.assertThat(javaQuestionService.add("testA", "testB"))
                .isEqualTo(new Question("testA", "testB"));
    }
    @Test
    void addCorrectDataQuestion() {
        Assertions.assertThat(javaQuestionService.getAll())
                .isEmpty();
        Assertions.assertThat(javaQuestionService.add(new Question("testA", "testB")))
                .isEqualTo(new Question("testA", "testB"));
    }

    @Test
    void removeCorrectData() {
        completionSet();
        Assertions.assertThat(javaQuestionService.getAll())
                .isNotEmpty();
        Assertions.assertThat(javaQuestionService.remove(new Question("Циклы в java?", "FOR, WHILE, DO WHILE, FOR EACH")))
                .isEqualTo(new Question("Циклы в java?", "FOR, WHILE, DO WHILE, FOR EACH"));
        Assertions.assertThat(javaQuestionService.getAll())
                .hasSize(1);
    }
    @Test
    void removeBadData() {
        completionSet();
        Assertions.assertThat(javaQuestionService.getAll())
                .isNotEmpty();
        Assertions.assertThatExceptionOfType(QuestionIsNotFoundException.class)
                .isThrownBy(() -> javaQuestionService.remove(new Question("test", "test")));
    }

    @Test
    void getRandomQuestions() {
        completionSet();
        Assertions.assertThat(javaQuestionService.getAll().contains(javaQuestionService.getRandomQuestion()))
                .isTrue();
    }

    private void completionSet() {
        javaQuestionService.add("Как обозначается элементарный тип целых чисел?", "int");
        javaQuestionService.add("Циклы в java?", "FOR, WHILE, DO WHILE, FOR EACH");
    }
}
