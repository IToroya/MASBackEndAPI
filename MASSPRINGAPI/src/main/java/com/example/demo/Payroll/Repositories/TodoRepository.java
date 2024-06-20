package com.example.demo.Payroll.Repositories;

import com.example.demo.Payroll.Entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}

