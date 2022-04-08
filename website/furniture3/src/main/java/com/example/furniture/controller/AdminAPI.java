package com.example.furniture.controller;

import com.example.furniture.pojo.Administrator;
import com.example.furniture.pojo.Equipment;
import com.example.furniture.pojo.Family;
import com.example.furniture.pojo.User;
import com.example.furniture.response.ResponseResult;
import com.example.furniture.services.FurnitureService;
import com.example.furniture.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/")
public class AdminAPI {

    @Autowired
    private UserService userService;
    @Autowired
    private FurnitureService furnitureService;

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping("/user")
    public ResponseResult addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/user/{userId}")
    public ResponseResult deleteUser(@PathVariable("userId") long userId) {
        return userService.deleteUser(userId);
    }

    /**
     * 修改管理员信息
     *
     * @param adminId
     * @param administrator
     * @return
     */
    @PutMapping("/admin/{adminId}")
    public ResponseResult modifyUser(@PathVariable("adminId") long adminId,
                                     @RequestBody Administrator administrator) {
        return userService.modifyAdmin(adminId, administrator);
    }

    /**
     * 修改用户
     *
     * @param user
     * @param userId
     * @return
     */
    @PutMapping("/user/{userId}")
    public ResponseResult modifyUser(@PathVariable("userId") long userId,
                                     @RequestBody User user) {
        return userService.modifyUser(userId, user);
    }

    /**
     * 用户列表
     *
     * @return
     */
    @GetMapping("/user-list/")
    public ResponseResult listUser() {
        return userService.listUser();
    }

    /**
     * 获取管理员自己信息
     *
     * @return
     */
    @GetMapping("/admin/{userId}")
    public ResponseResult getUserAdmin(@PathVariable("userId") long userId) {
        return userService.getUserAdmin(userId);
    }

    /**
     * 添加家庭
     *
     * @param family
     * @return
     */
    @PostMapping("/family")
    public ResponseResult addFamily(@RequestBody Family family) {
        return userService.addFamily(family);
    }

    /**
     * 删除家庭
     *
     * @param familyId
     * @return
     */
    @DeleteMapping("/family/{familyId}")
    public ResponseResult deleteFamily(@PathVariable("familyId") long familyId) {
        return userService.deleteFamily(familyId);
    }

    /**
     * 修改家庭
     *
     * @param familyid
     * @param family
     * @return
     */
    @PutMapping("/family/{familyId}")
    public ResponseResult modifyFamily(@PathVariable("familyId") long familyid,
                                       @RequestBody Family family) {
        return userService.modifyFamily(family, familyid);
    }

    /**
     * 获取家庭列表
     *
     * @return
     */
    @GetMapping("/family/list")
    public ResponseResult getFamilyList() {
        return userService.getFamilyList();
    }

    /**
     * 添加设备
     *
     * @param equipment
     * @param type      1 2 3 不能类型的设备
     * @return
     */
    @PostMapping("/equipment/{type}")
    public ResponseResult addEquipment(@RequestBody Equipment equipment,
                                       @PathVariable("type") String type) {
        return furnitureService.addEquipment(equipment, type);
    }

    /**
     * 删除设备
     *
     * @param equipmentId
     * @return
     */
    @DeleteMapping("/equipment/{equipmentId}")
    public ResponseResult deleteEquipment(@PathVariable("equipmentId") Long equipmentId) {
        return furnitureService.deleteEquipment(equipmentId);
    }

    /**
     * 修改设备
     *
     * @param equipmentId
     * @return
     */
    @PutMapping("/equipment/{equipmentId}")
    public ResponseResult modifyEquipment(@PathVariable("equipmentId") long equipmentId,
                                          @RequestBody Equipment equipment) {
        return furnitureService.modifyEquipment(equipmentId, equipment);
    }
}
