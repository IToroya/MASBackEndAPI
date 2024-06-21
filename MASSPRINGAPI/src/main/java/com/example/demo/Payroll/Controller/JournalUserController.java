package com.example.demo.Payroll.Controller;

import com.example.demo.Payroll.Entities.JournalUser;
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

    /**@PostMapping("/users")
    public JournalUser newUser(@RequestBody String email, String password) {
        if (repository.findByEmailAndPassword(email, password).isPresent()) {
            throw new JournalUserAlreadyExistsException(email);
        }
        else {
            JournalUser user = new JournalUser(email, password);
            return repository.save(user);
        }
    }**/

    @GetMapping("/users/{id}")
    public JournalUser one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new JournalUserNotFoundException(id));
    }

    @GetMapping("/users/check")
    public ResponseEntity<Boolean> checkJournalUser(@RequestParam String email,@RequestParam String password) {
        boolean userExists = repository.findByEmailAndPassword(email, password).isPresent();
        if (userExists) {
            return ResponseEntity.ok(true);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

    @PutMapping("/users/{id}")
    public JournalUser replaceUser(@PathVariable Long id, @RequestBody JournalUser newJournalUser) {
        return repository.findById(id)
                .map(journalUser -> {
                    journalUser.setEmail(newJournalUser.getEmail());
                    journalUser.setPassword(newJournalUser.getPassword());
                    return repository.save(journalUser);
                })
                .orElseGet(() -> {
                    newJournalUser.setId(id);
                    return repository.save(newJournalUser);
                });
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
