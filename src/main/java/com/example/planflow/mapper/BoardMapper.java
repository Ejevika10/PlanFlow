package com.example.planflow.mapper;

import com.example.planflow.dto.RequestBoardDTO;
import com.example.planflow.dto.ResponseBoardDTO;
import com.example.planflow.models.Board;
import com.example.planflow.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface BoardMapper {
    RequestBoardDTO toReqDto(Board board);
    ResponseBoardDTO toRespDto(Board board);
    Board toBoard(RequestBoardDTO requestBoardDTO);
    Board toBoard(ResponseBoardDTO responseBoardDTO);
}
