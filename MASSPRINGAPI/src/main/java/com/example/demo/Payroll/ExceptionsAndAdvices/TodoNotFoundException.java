package com.example.demo.Payroll.ExceptionsAndAdvices;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(Long id) {
        super("Could not find todo with id " + id);
    }
}
