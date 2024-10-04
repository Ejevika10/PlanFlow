package com.example.planflow.repositories;

import com.example.planflow.models.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubtaskRepository extends JpaRepository<Subtask, Long> {
    boolean existsById(Long id);
    @Query("SELECT t.subtasks FROM Task t WHERE t.id = :taskId")
    List<Subtask> findAllByTaskId(@Param("taskId") Long taskId);

}
