package com.example.demo.Payroll.Repositories;

import com.example.demo.Payroll.Entities.JournalUser;
import com.example.demo.Payroll.Entities.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Date;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    Date date =new Date();
    Long dateAsLong = date.getTime();

    // Will be run automatically on startup
    @Bean
    CommandLineRunner initDatabase(TodoRepository repository, JournalUserRepository journalUserRepository) {

        return args -> {
            log.info("Preloading " + repository.save(new Todo(1, "Todo 1", "Eat vegetables", false, false, dateAsLong)));
            log.info("Preloading " + repository.save(new Todo(2, "Todo 2", "Eat even more vegetables", false, false, dateAsLong)));
            log.info("Preloading " + journalUserRepository.save(new JournalUser(1, "vincent.berndt@gmail.com", "1928319")));
            log.info("Preloading " + journalUserRepository.save(new JournalUser(2, "nico.rueckner@gmail.com", "128372349")));
        };
    }
}