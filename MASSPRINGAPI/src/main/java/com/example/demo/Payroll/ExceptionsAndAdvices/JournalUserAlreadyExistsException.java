package com.example.demo.Payroll.ExceptionsAndAdvices;

public class JournalUserAlreadyExistsException extends RuntimeException {
    public JournalUserAlreadyExistsException(Long id) {super("JournalUser with id " + id + " already exists");
    }
}

