package com.example.planflow.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private State state;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "last_date", nullable = false)
    private Date lastDate;

    @Column(name = "time_estimate", nullable = false)
    private String timeEstimate;

    @Column(nullable = false)
    private Priority priority;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "task_assignees",
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id") )
    private List<User> assignees;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Subtask> subtasks;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;
}
