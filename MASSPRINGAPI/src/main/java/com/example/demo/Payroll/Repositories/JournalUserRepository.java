package com.example.demo.Payroll.Repositories;

import com.example.demo.Payroll.Entities.JournalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalUserRepository extends JpaRepository<JournalUser, Long> {

}
