package com.green.boardver3pr.user;

import com.green.boardver3pr.user.model.UserPostReq;
import com.green.boardver3pr.user.model.ChangePasswordReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
     int postUser(UserPostReq p);
     String searchUid(String uid);
     UserPostReq getUserEntity (String uid);
     int patchPassword(ChangePasswordReq p);
}
