package com.example.planflow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "boards")
public class Board {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name ="creator_id", nullable = false)
    private User creator;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "board_assignees",
        joinColumns = @JoinColumn(name = "board_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id") )
    private List<User> assignees = new ArrayList<>();
}
