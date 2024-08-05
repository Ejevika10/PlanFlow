package com.example.planflow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "subtask")
public class Subtask {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean is_complete;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;
}
