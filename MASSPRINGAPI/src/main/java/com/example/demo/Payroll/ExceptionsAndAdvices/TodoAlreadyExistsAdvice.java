package com.example.demo.Payroll.ExceptionsAndAdvices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TodoAlreadyExistsAdvice {

    @ResponseBody
    @ExceptionHandler(TodoAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public String todoAlreadyExistsHandler(TodoAlreadyExistsException ex) {
        return ex.getMessage();
    }
}
