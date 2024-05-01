package com.green.boardver3pr.user;

import com.green.boardver3pr.common.ResultDto;
import com.green.boardver3pr.user.model.UserPostReq;
import com.green.boardver3pr.user.model.ChangePasswordReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @PostMapping("signup")
    public ResultDto<Integer> postUser (@RequestBody UserPostReq p ){
        return userService.postUser(p);
    }
    @PutMapping
        public ResultDto<Integer> patchPassword(@RequestBody ChangePasswordReq p){
        return userService.patchPassword(p);
    }
}
