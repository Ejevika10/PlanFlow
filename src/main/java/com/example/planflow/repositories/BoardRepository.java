package com.example.planflow.repositories;

import com.example.planflow.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    boolean existsById(Long id);

    @Query("SELECT u.boards FROM User u WHERE u.id = :userId")
    List<Board> findAllByUserId(@Param("userId") Long userId);
}
