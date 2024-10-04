package com.example.planflow.services.implementation;

import com.example.planflow.dto.RequestBoardDTO;
import com.example.planflow.dto.ResponseBoardDTO;
import com.example.planflow.mapper.BoardListMapper;
import com.example.planflow.mapper.BoardMapper;
import com.example.planflow.models.Board;
import com.example.planflow.repositories.BoardRepository;
import com.example.planflow.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BoardServiceImplementation implements BoardService {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardMapper boardMapper;
    @Autowired
    private BoardListMapper boardListMapper;

    @Override
    public List<ResponseBoardDTO> getAllBoards() {
        List<Board> boards = boardRepository.findAll();
        return boardListMapper.toBoardRespDto(boards);
    }

    @Override
    public List<ResponseBoardDTO> getAllBoardsByUserId(Long userId) {
        List<Board> boards = boardRepository.findAllByUserId(userId);
        return boardListMapper.toBoardRespDto(boards);
    }

    @Override
    public ResponseBoardDTO getBoardById(Long boardId) {
        Board board = boardRepository.findById(boardId).orElse(null);
        return boardMapper.toRespDto(board);
    }

    @Override
    public ResponseBoardDTO createBoard(RequestBoardDTO requestBoardDTO) {
        Board board = boardRepository.save(boardMapper.toBoard(requestBoardDTO));
        return boardMapper.toRespDto(board);
    }

    @Override
    public ResponseBoardDTO updateBoard(RequestBoardDTO requestBoardDTO) {
        if(boardRepository.existsById(requestBoardDTO.getId())) {
            Board board = boardRepository.save(boardMapper.toBoard(requestBoardDTO));
            return boardMapper.toRespDto(board);
        }
        return null;
    }

    @Override
    public boolean deleteBoard(Long boardId) {
        if(boardRepository.existsById(boardId)) {
            boardRepository.deleteById(boardId);
            return true;
        }
        return false;
    }
}
