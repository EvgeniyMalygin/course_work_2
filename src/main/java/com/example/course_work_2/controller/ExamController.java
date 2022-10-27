package com.example.course_work_2.controller;

import com.example.course_work_2.interFace.ExaminerService;
import com.example.course_work_2.model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("random")

    public Collection<Question> getRandomQuestion(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }
}
