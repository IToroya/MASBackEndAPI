package com.example.demo.Payroll.Controller;

import com.example.demo.Payroll.Entities.JournalUser;
import com.example.demo.Payroll.Entities.JournalUserStatus;
import com.example.demo.Payroll.ExceptionsAndAdvices.JournalUserAlreadyExistsException;
import com.example.demo.Payroll.ExceptionsAndAdvices.JournalUserNotFoundException;
import com.example.demo.Payroll.ExceptionsAndAdvices.TodoNotFoundException;
import com.example.demo.Payroll.Repositories.JournalUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JournalUserController {

    private final JournalUserRepository repository;

    JournalUserController(JournalUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public List<JournalUser> all() {
        return repository.findAll();
    }

    @PostMapping("/users/check")
    public ResponseEntity<JournalUserStatus> checkJournalUser(@RequestBody JournalUser journalUser) {
        JournalUserStatus userStatus = new JournalUserStatus(repository.findByEmailAndPassword(journalUser.getEmail(), journalUser.getPassword()).isPresent());
        if (userStatus.isStatus()) {
            return ResponseEntity.ok(userStatus);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userStatus);
    }

}
