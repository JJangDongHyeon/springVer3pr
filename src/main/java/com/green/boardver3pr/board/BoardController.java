package com.green.boardver3pr.board;

import com.green.boardver3pr.board.model.BoardGetReq;
import com.green.boardver3pr.board.model.BoardGetRes;
import com.green.boardver3pr.board.model.BoardPostReq;
import com.green.boardver3pr.common.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
    private final BoardService service;

    @PostMapping
    public ResultDto<Integer> boardPost(@RequestBody BoardPostReq p){
        int result = service.boardPost(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("작성 완료")
                .resultData(1)
                .build();
    }

    @DeleteMapping
    public ResultDto<Integer> boardDelete(@RequestParam long boardId){
        int result = service.boardDelete(boardId);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("삭제완료")
                .resultData(result)
                .build();
    }

    @GetMapping
    public ResultDto<List<BoardGetRes>> getBoardList(@ModelAttribute BoardGetReq p){
        List<BoardGetRes> list = service.getBoardList(p);
        return ResultDto.<List<BoardGetRes>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(list)
                .build();
    }

}
