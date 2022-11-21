package com.vero.todoapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vero.todoapp.persistence.entity.Task;
import com.vero.todoapp.persistence.entity.TaskStatus;
import com.vero.todoapp.services.TaskService;
import com.vero.todoapp.services.dto.TaskInDTO;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> seeAll(){
        return this.taskService.seeAll();
    }

    @GetMapping(path = "/status/{status}")
    public List<Task> seeAllByStatus(@PathVariable("status") TaskStatus status){
        return this.taskService.seeAllByStatus(status);
    }

    @PatchMapping("/markAsCompleted/{id}")
    public ResponseEntity<Void> markAsCompleted(@PathVariable("id") Long id){
        this.taskService.markAsCompleted(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id){
        this.taskService.deleteTask(id);;
        return ResponseEntity.noContent().build();
    }
    
}
