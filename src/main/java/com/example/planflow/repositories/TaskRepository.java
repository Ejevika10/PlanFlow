package com.example.planflow.repositories;

import com.example.planflow.models.Subtask;
import com.example.planflow.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    boolean existsById(Long id);

    @Query("SELECT u.tasks FROM User u WHERE u.id = :userId")
    List<Task> findAllByUserId(@Param("userId") Long userId);
}
