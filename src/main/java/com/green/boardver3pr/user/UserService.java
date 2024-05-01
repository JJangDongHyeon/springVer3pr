package com.green.boardver3pr.user;

import com.green.boardver3pr.common.ResultDto;
import com.green.boardver3pr.user.model.UserPostReq;
import com.green.boardver3pr.user.model.ChangePasswordReq;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public ResultDto<Integer> postUser (UserPostReq p){
       String uid = mapper.searchUid(p.getUid());
       if(uid != null){
           return ResultDto.<Integer>builder()
                   .statusCode(HttpStatus.OK)
                   .resultMsg("중복된 uid입니다.")
                   .resultData(0)
                   .build();
       }
        String hashedPassword = BCrypt.hashpw(p.getUpw() , BCrypt.gensalt() );
        p.setUpw(hashedPassword);
        int result = mapper.postUser(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("회원 가입 성공!")
                .resultData(result)
                .build();
    }

    public ResultDto<Integer> patchPassword(ChangePasswordReq p){
        UserPostReq userEntity = mapper.getUserEntity(p.getUid());
        if(userEntity == null){
            return ResultDto.<Integer>builder()
                    .statusCode(HttpStatus.OK)
                    .resultMsg("아이디가 없습니다.")
                    .resultData(0)
                    .build();

        } else if(!BCrypt.checkpw(p.getCurrentUpw() , userEntity.getUpw())){
            return ResultDto.<Integer>builder()
                    .statusCode(HttpStatus.OK)
                    .resultMsg("비밀번호가 다릅니다.")
                    .resultData(0)
                    .build();
        } else if (BCrypt.checkpw(p.getNewUpw(), userEntity.getUpw())) {
            return ResultDto.<Integer>builder()
                    .statusCode(HttpStatus.OK)
                    .resultMsg("쓰던 비밀번호와 같습니다.")
                    .resultData(0)
                    .build();
        }
        String hashedPassword = BCrypt.hashpw(p.getNewUpw() , BCrypt.gensalt());
        p.setNewUpw(hashedPassword);
        mapper.patchPassword(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("비밀번호가 교체되었습니다.")
                .resultData(1)
                .build();

    }
}
