package com.example.demo.Payroll.Controller;

import com.example.demo.Payroll.Entities.Todo;
import com.example.demo.Payroll.ExceptionsAndAdvices.TodoAlreadyExistsException;
import com.example.demo.Payroll.ExceptionsAndAdvices.TodoNotFoundException;
import com.example.demo.Payroll.Repositories.TodoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TodoController {

    private final TodoRepository repository;

    TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todos")
    public List<Todo> all() {
        return repository.findAll();
    }

    @PostMapping("/todos")
    public Todo newTodo(@RequestBody Todo todo) {
        if (repository.existsById(todo.getId())) {
            throw new TodoAlreadyExistsException(todo.getId());
        }
        else
            return repository.save(todo);
    }

    @GetMapping("/todos/{id}")
    public Todo one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }

    @PutMapping("/todos/{id}")
    public Todo replaceTodo(@PathVariable Long id, @RequestBody Todo newTodo) {
        return repository.findById(id)
                .map(todo -> {
                    todo.setName(newTodo.getName());
                    todo.setDescription(newTodo.getDescription());
                    todo.setBookmarked(newTodo.isBookmarked());
                    todo.setFinished(newTodo.isFinished());
                    todo.setDueDate(newTodo.getDueDate());
                    return repository.save(todo);
                })
                .orElseGet(() -> {
                    newTodo.setId(id);
                    return repository.save(newTodo);
                });
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
