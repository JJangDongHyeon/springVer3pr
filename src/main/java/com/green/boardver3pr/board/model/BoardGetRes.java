package com.green.boardver3pr.board.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardGetRes {
    private long boardId;
    private String title;
    private long writerId;
    private String writerNm;
    private int hits;
    private String createdAt;
}
