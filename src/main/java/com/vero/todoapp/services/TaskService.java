package com.vero.todoapp.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vero.todoapp.exceptions.ToDoExceptions;
import com.vero.todoapp.mapper.TaskInDTOToTask;
import com.vero.todoapp.persistence.entity.Task;
import com.vero.todoapp.persistence.entity.TaskStatus;
import com.vero.todoapp.persistence.repository.TaskRepository;
import com.vero.todoapp.services.dto.TaskInDTO;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

@Service
public class TaskService {
    
    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

   
    public List<Task> seeAll(){
        return this.repository.findAll();
    }

    public List<Task> seeAllByStatus(TaskStatus status){
        return this.repository.findAllByStatus(status);
    }

    @Transactional
    public void markAsCompleted(Long id){
        Optional<Task> optionalTask =  this.repository.findById(id);
        if (optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markAsCompleted(id);
    }

    public void deleteTask(Long id){
        Optional<Task> optionalTask =  this.repository.findById(id);
        if (optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
}
