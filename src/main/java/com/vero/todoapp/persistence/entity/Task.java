package com.vero.todoapp.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String tittle;
    private String description;
    private LocalDateTime creationDay;
    private LocalDateTime deadline;
    private boolean completed;
    private TaskStatus status;
    
}
