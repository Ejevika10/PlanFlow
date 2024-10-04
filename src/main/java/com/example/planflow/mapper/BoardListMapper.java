package com.example.planflow.mapper;

import com.example.planflow.dto.RequestBoardDTO;
import com.example.planflow.dto.ResponseBoardDTO;
import com.example.planflow.models.Board;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = BoardMapper.class)
public interface BoardListMapper {
    List<Board> toBoardList(List<RequestBoardDTO> boards);
    List<ResponseBoardDTO> toBoardRespDto(List<Board> boards);
}
