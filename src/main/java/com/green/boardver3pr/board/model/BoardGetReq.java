package com.green.boardver3pr.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardGetReq {
    private int page;
    private int size;

    @JsonIgnore
    private int startIdx;

    public BoardGetReq(Integer page , Integer size){
        this.page = page == null ? 1 : page;
        this.size = size == null ? 10 : size;
        this.startIdx = (this.page - 1) * this.size;
    }

}
