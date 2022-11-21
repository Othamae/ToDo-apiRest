package com.vero.todoapp.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.vero.todoapp.persistence.entity.Task;
import com.vero.todoapp.persistence.entity.TaskStatus;
import com.vero.todoapp.services.dto.TaskInDTO;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task>{

    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTittle(in.getTittle());
        task.setDescription(in.getDescription());
        task.setDeadline(in.getDeadline());
        task.setCreationDay(LocalDateTime.now());
        task.setCompleted(false);
        task.setStatus(TaskStatus.ON_TIME);
        return task;
    }
    
}
