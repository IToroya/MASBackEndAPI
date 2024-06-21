package com.example.demo.Payroll.ExceptionsAndAdvices;

public class JournalUserNotFoundException extends RuntimeException {
    public JournalUserNotFoundException(Long id) {
        super("Could not find user with id " + id);
    }
    public JournalUserNotFoundException(String email) {super("Could not find user with email " + email);}
}
