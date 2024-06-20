package com.example.demo.Payroll.ExceptionsAndAdvices;

public class TodoAlreadyExistsException extends RuntimeException {
    public TodoAlreadyExistsException(Long id) {
            super("Todo with id " + id + " already exists");
    }
}

