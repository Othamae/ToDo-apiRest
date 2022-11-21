package com.vero.todoapp.services.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TaskInDTO {    
    private String tittle;
    private String description;    
    private LocalDateTime deadline;
    
}
