package com.example.course_work_2.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NumberOfQuestionIsNotPresentException extends RuntimeException {

    public NumberOfQuestionIsNotPresentException() {
    }
}
