package com.green.boardver3pr.board;

import com.green.boardver3pr.board.model.BoardGetReq;
import com.green.boardver3pr.board.model.BoardGetRes;
import com.green.boardver3pr.board.model.BoardPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    public int boardPost(BoardPostReq p){
        return mapper.postBoard(p);
    }
    public int boardDelete(long boardId){
        return mapper.boardDelete(boardId);
    }
    public List<BoardGetRes> getBoardList(BoardGetReq p){
        return mapper.getBoardList(p);
    }
}
