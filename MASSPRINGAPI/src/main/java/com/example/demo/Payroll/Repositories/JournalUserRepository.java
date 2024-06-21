package com.example.demo.Payroll.Repositories;

import com.example.demo.Payroll.Entities.JournalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JournalUserRepository extends JpaRepository<JournalUser, Long> {
    Optional<JournalUser> findByEmailAndPassword(String email, String password);
}
