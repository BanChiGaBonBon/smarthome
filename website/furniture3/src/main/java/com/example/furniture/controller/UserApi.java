package com.example.furniture.controller;

import com.example.furniture.pojo.Administrator;
import com.example.furniture.pojo.User;
import com.example.furniture.pojo.UserOrAdmin;
import com.example.furniture.response.ResponseResult;
import com.example.furniture.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
/**
 * 用户API
 */
public class UserApi {

    @Autowired
    private UserService userService;

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user) {
        return userService.register(user);
    }

    /**
     * 注册管理员
     *
     * @param administrator
     * @return
     */
    @PostMapping("/register-a")
    public ResponseResult registerAdmin(@RequestBody Administrator administrator) {
        return userService.registerAdmin(administrator);
    }

    /**
     * 获取登录用户
     *
     * @return
     */
    @GetMapping("/login-u")
    public ResponseResult loginUser() {
        return userService.getLoginUser();
    }

    /**
     * 登录
     *
     * @param userOrAdmin
     * @return
     */
    @PostMapping("/login/{type}")
    public ResponseResult login(@RequestBody UserOrAdmin userOrAdmin,
                                @PathVariable("type") int type) {
        return userService.login(userOrAdmin, type);
    }

    /**
     * 退出
     *
     */
    @PostMapping("/logout")
    public ResponseResult logout() {
        return userService.logout();
    }

    /**
     * 获取用户列表
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list/{page}/{size}")
    public ResponseResult getUser(@PathVariable("page") int page,
                                  @PathVariable("size") int size) {
        return userService.getUserList(page, size);
    }

    /**
     * 查询家庭
     *
     * @param familyId
     * @return
     */
    @GetMapping("/family/{familyId}")
    public ResponseResult getFamily(@PathVariable("familyId") long familyId) {
        return userService.getFamily(familyId);
    }

    /**
     * 查询用户
     *
     * @param userId
     * @return
     */
    @GetMapping("/user/{userId}")
    public ResponseResult getUser(@PathVariable("userId") long userId) {
        return userService.getUser(userId);
    }


}
