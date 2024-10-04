package com.example.planflow.controllers;


import com.example.planflow.dto.RequestBoardDTO;
import com.example.planflow.dto.ResponseBoardDTO;
import com.example.planflow.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping
    public ResponseEntity<List<ResponseBoardDTO>> getAllBoards() {
        return new ResponseEntity<>(boardService.getAllBoards(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBoardDTO> getBoard(@PathVariable Long id) {
        ResponseBoardDTO board = boardService.getBoardById(id);
        return board != null ? new ResponseEntity<>(board, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ResponseBoardDTO> createBoard(@RequestBody RequestBoardDTO requestBoardDTO){
        return new ResponseEntity<>(boardService.createBoard(requestBoardDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseBoardDTO> updateBoard(@RequestBody RequestBoardDTO requestBoardDTO){
        ResponseBoardDTO updatedBoard = boardService.updateBoard(requestBoardDTO);
        return updatedBoard != null ? new ResponseEntity<>(updatedBoard, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id){
        return boardService.deleteBoard(id) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}

