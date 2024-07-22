package org.example.dictionaryeejaxws.server.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 10)
    private TaskStatus status;

    @Column(name = "creationDate", nullable = false)
    private LocalDate creationDate;

    @Column(name = "attempts", nullable = false)
    private Integer attempts;

    @Column(name = "errorMessage", length = 300)
    private String errorMessage;

    public Task(String name, TaskStatus status, LocalDate creationDate, Integer attempts) {
        this.name = name;
        this.status = status;
        this.creationDate = creationDate;
        this.attempts = attempts;
    }

    public Task() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(name, task.name) && status == task.status && Objects.equals(creationDate, task.creationDate) && Objects.equals(attempts, task.attempts) && Objects.equals(errorMessage, task.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, creationDate, attempts, errorMessage);
    }
}