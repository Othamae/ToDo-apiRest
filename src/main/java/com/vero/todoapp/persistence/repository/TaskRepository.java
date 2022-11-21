package com.vero.todoapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vero.todoapp.persistence.entity.Task;
import com.vero.todoapp.persistence.entity.TaskStatus;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAllByStatus(TaskStatus status);

    @Modifying
    @Query(value = "UPDATE TASK SET COMPLETED=true WHERE ID=:id", nativeQuery = true)
    public void markAsCompleted(@Param("id") Long id);
   

}
