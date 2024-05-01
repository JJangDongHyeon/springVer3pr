package com.green.boardver3pr.board;

import com.green.boardver3pr.board.model.BoardGetReq;
import com.green.boardver3pr.board.model.BoardGetRes;
import com.green.boardver3pr.board.model.BoardPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface  BoardMapper {
    int postBoard(BoardPostReq p);
    int boardDelete(long boardId);
    List<BoardGetRes> getBoardList(BoardGetReq p);
}
