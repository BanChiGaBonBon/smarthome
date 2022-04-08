package com.example.furniture.services;

import com.example.furniture.pojo.*;
import com.example.furniture.response.ResponseResult;

public interface UserService {
    ResponseResult register(User user);

    ResponseResult registerAdmin(Administrator administrator);

    ResponseResult getLoginUser();

    ResponseResult login(UserOrAdmin userOrAdmin, int type);

    ResponseResult logout();

    ResponseResult addUser(User user);

    ResponseResult deleteUser(long userId);

    ResponseResult modifyUser(long userId, User user);

    ResponseResult getUser(long userId);

    ResponseResult getUserList(int page, int size);

    ResponseResult getUserAdmin(long userId);

    ResponseResult addFamily(Family family);

    ResponseResult deleteFamily(long familyId);

    ResponseResult modifyFamily(Family family, long familyid);

    ResponseResult getFamily(long familyId);

    ResponseResult getFamilyList();

    ResponseResult modifyAdmin(long adminId, Administrator administrator);

    ResponseResult listUser();
}
