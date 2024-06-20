package com.example.demo.Payroll.ExceptionsAndAdvices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class JournalUserNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(JournalUserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundHandler(JournalUserNotFoundException ex) {
        return ex.getMessage();
    }
}