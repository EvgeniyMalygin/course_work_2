package com.example.course_work_2.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuestionIsNotFoundException extends RuntimeException{
    public QuestionIsNotFoundException() {
    }
}
