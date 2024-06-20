package com.example.demo.Payroll.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

// Dataobject used for persistent storage
@Getter
@Setter
@ToString
@Entity
public class Todo {
    private @Id Long id;
    private String name;
    private String description;
    private boolean finished;
    private boolean bookmarked;
    private long dueDate;

    public Todo() {
    }

    public Todo(long id, String name, String description, boolean finished, boolean bookmarked, long dueDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.finished = finished;
        this.bookmarked = bookmarked;
        this.dueDate = dueDate;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Todo todo = (Todo) o;
        return getId() != null && Objects.equals(getId(), todo.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
