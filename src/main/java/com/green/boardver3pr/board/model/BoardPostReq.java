package com.green.boardver3pr.board.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardPostReq {
    private String title;
    private String contents;
    private long writerId;
}
