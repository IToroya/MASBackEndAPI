package com.example.demo.Payroll.ExceptionsAndAdvices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class JournalUserAlreadyExistsAdvice {

    @ResponseBody
    @ExceptionHandler(JournalUserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public String JournalUserAlreadyExistsHandler(JournalUserAlreadyExistsException ex) {
        return ex.getMessage();
    }
}
