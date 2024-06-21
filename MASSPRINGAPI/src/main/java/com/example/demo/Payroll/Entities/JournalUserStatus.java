package com.example.demo.Payroll.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class JournalUserStatus {
    private @Id boolean status;

    public JournalUserStatus(boolean status) {
        this.status = status;
    }
    public JournalUserStatus() {}

}
