package com.green.boardver3pr.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordReq {
    private String uid;
    private String currentUpw;
    private String newUpw;
}
