package com.example.planflow.services;

import com.example.planflow.dto.RequestBoardDTO;
import com.example.planflow.dto.ResponseBoardDTO;

import java.util.List;

public interface BoardService {
    List<ResponseBoardDTO> getAllBoards();
    List<ResponseBoardDTO> getAllBoardsByUserId(Long userId);
    ResponseBoardDTO getBoardById(Long boardId);
    ResponseBoardDTO createBoard(RequestBoardDTO requestBoardDTO);
    ResponseBoardDTO updateBoard(RequestBoardDTO requestBoardDTO);
    boolean deleteBoard(Long boardId);
}
