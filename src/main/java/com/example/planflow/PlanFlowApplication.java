package com.example.planflow;

import com.example.planflow.models.*;
import com.example.planflow.repositories.BoardRepository;
import com.example.planflow.repositories.SubtaskRepository;
import com.example.planflow.repositories.TaskRepository;
import com.example.planflow.repositories.UserRepository;
import com.example.planflow.services.UserService;
import com.example.planflow.services.implementation.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class PlanFlowApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    SubtaskRepository subtaskRepository;


    public static void main(String[] args) {
        SpringApplication.run(PlanFlowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Board> boards = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ADMIN);
        List<Subtask> subtasks = new ArrayList<>();
        User user1 = new User(1L,"2222","2222","2222","2222",roles,boards,tasks);
        User user2 = new User(2L,"1111","1111","1111","1111",roles,boards,tasks);
        userRepository.save(user1);
        userRepository.save(user2);
        List<User> assignees = new ArrayList<>();
        assignees.add(user2);
        Board board1 = new Board(1L,"board","first_board",user1,assignees,tasks);
        boardRepository.save(board1);
        Date date1 = new Date(2024,8,11);
        Date date2 = new Date(2024,9,11);
        Task task1 = new Task(1L,"task","first_task", State.ToDo,date1,date2,"12h", Priority.High,assignees,subtasks,board1);
        taskRepository.save(task1);
        Subtask subtask = new Subtask(1L, "subtask",false,task1);
        subtaskRepository.save(subtask);
        //System.out.println(Arrays.toString(userRepository.findAll().toArray()));
        //System.out.println(Arrays.toString(userService.getAllUsers().toArray()));
    }
}
