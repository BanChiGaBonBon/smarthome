package com.example.furniture.services;

import com.example.furniture.mapper.EquipmentMapper;
import com.example.furniture.mapper.UserMapper;
import com.example.furniture.mapper.AdministratorMapper;
import com.example.furniture.mapper.FamilyMapper;
import com.example.furniture.pojo.*;
import com.example.furniture.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.furniture.utils.CookieUtils;
import com.example.furniture.utils.ServletUtils;

import java.util.List;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private FamilyMapper familyMapper;
    @Autowired
    private AdministratorMapper administratorMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FurnitureService furnitureService;
    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public ResponseResult register(User user) {
        User userByUserName = userMapper.findUserByUserName(user.getUserName());
        if (userByUserName != null) {
            return ResponseResult.FAILED("repeat of user name");
        }
        User userById = userMapper.findUserById(user.getUserId());
        if (userById != null) {
            return ResponseResult.FAILED("This ID is already occupied");
        }
        Family family = user.getFamily();
        if (family != null) {
            family.setFamilyId(user.getFamilyId());
            Family family1 = familyMapper.selectByPrimaryKey(family);
            if (family1 != null) {
                return ResponseResult.FAILED("The home ID already exists. Please replace the home ID");
            }
            familyMapper.insert(family);
        }
        int insert = userMapper.insert(user);
        if (insert == 1) {
            return ResponseResult.SUCCESS("register was successful！！");
        }
        return ResponseResult.FAILED("Registration failed, please try again");
    }

    public ResponseResult registerAdmin(Administrator administrator) {
        Administrator userByUserName = administratorMapper.findUserByUserName(administrator.getAdministratorName());
        if (userByUserName != null) {
            return ResponseResult.FAILED("Duplicate administrator name");
        }
        Administrator userById = administratorMapper.findUserById(administrator.getAdministratorId());
        if (userById != null) {
            return ResponseResult.FAILED("This ID is occupied");
        }
        int insert = administratorMapper.insert(administrator);
        if (insert == 1) {
            return ResponseResult.SUCCESS("login was successful！！");
        }
        return ResponseResult.FAILED("Registration failed, please try again");
    }

//Out of range value for column 'equipment_id' at row 1 超范围了
    /**
     * 获取登录用户
     *
     * @return
     */
    @Override
    public ResponseResult getLoginUser() {
        String smarthome = CookieUtils.getCookie(ServletUtils.getRequest(), "smarthome");
        if (smarthome == null) {
            return ResponseResult.FAILED();
        }
        String type = smarthome.split("-")[1];
        long loginUserId = Integer.valueOf(smarthome.split("-")[0]);
        if ("U".equals(type)){
            User user = userMapper.findUserById(loginUserId);
            user.setUserPassword("");
            return ResponseResult.SUCCESS().setData(user);
        }else if("A".equals(type)){
            Administrator administrator = administratorMapper.findUserById(loginUserId);
            administrator.setAdministratorPassword("");
            return ResponseResult.SUCCESS().setData(administrator);
        }else {
            return ResponseResult.FAILED("User not logged in");
        }
    }

    /**
     * 登录
     *
     * @param userOrAdmin
     * @param type
     * @return
     */
    @Override
    public ResponseResult login(UserOrAdmin userOrAdmin, int type) {
        if (type == 1) {
            return loginUser(userOrAdmin.getUser());
        } else {
            return loginAdmin(userOrAdmin.getAdministrator());
        }
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    private ResponseResult loginUser(User user) {
        User userFromDB = userMapper.findUserByUserName(user.getUserName());
        if (userFromDB == null) {
            return ResponseResult.FAILED("This user is not registered, please register first");
        }
        if (!userFromDB.getUserPassword().equals(user.getUserPassword())) {
            return ResponseResult.FAILED("Wrong user name or password");
        }
        CookieUtils.setCookie(ServletUtils.getResponse(), "smarthome", userFromDB.getUserId() + "-U");
        userFromDB.setExisted(1L);
        userMapper.updateByPrimaryKey(userFromDB);
        return ResponseResult.SUCCESS("Login successful").setData(userFromDB);
    }

    /**
     * 管理员登录
     *
     * @param administrator
     * @return
     */
    private ResponseResult loginAdmin(Administrator administrator) {
        Administrator administratorFromDB = administratorMapper.findUserByUserName(administrator.getAdministratorName());
        if (administratorFromDB == null) {
            return ResponseResult.FAILED("This administrator is not registered. Please register first");
        }
        if (!administratorFromDB.getAdministratorPassword().equals(administrator.getAdministratorPassword())) {
            return ResponseResult.FAILED("Administrator name or password error");
        }
        CookieUtils.setCookie(ServletUtils.getResponse(), "smarthome", administratorFromDB.getAdministratorId() + "-A");
        return ResponseResult.SUCCESS("Login successful").setData(administratorFromDB);
    }

    /**
     * 退出
     *
     * @return
     */
    @Override
    public ResponseResult logout() {
        String smarthome = CookieUtils.getCookie(ServletUtils.getRequest(), "smarthome");
        String type = smarthome.split("-")[1];
        long loginUserId = Integer.valueOf(smarthome.split("-")[0]);
        if ("U".equals(type)){
            User user = new User();
            user.setUserId(loginUserId);
            User user1 = userMapper.selectByPrimaryKey(user);
            user1.setExisted(0L);
            userMapper.updateByPrimaryKey(user1);
        }else if ("A".equals(type)){
            Administrator administrator = new Administrator();
            administrator.setAdministratorId(loginUserId);
            Administrator administrator1 = administratorMapper.selectByPrimaryKey(administrator);
        }else {
            return ResponseResult.FAILED("This user is not logged in");
        }
        CookieUtils.deleteCookie(ServletUtils.getResponse(), "smarthome");
        return ResponseResult.SUCCESS("Exit successful");
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public ResponseResult addUser(User user) {
        User userById = userMapper.findUserById(user.getUserId());
        if (userById != null) {
            return ResponseResult.FAILED("This ID is already occupied");
        }
        User userByUserName = userMapper.findUserByUserName(user.getUserName());
        if (userByUserName != null) {
            return ResponseResult.FAILED("repeat of user name");
        }
        Family family = new Family();
        family.setFamilyId(user.getFamilyId());
        Family family1 = familyMapper.selectByPrimaryKey(family);
        if (family1==null){
            return ResponseResult.FAILED("Family does not exist");
        }
        int insert = userMapper.insert(user);
        if (insert == 1) {
            return ResponseResult.SUCCESS("add user was successful！！");
        }
        return ResponseResult.FAILED("add failed, please try again");
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseResult deleteUser(long userId) {
        User user = getUserById(userId);
        if (user == null) {
            return ResponseResult.FAILED("没有对应的用户");
        }
        int i = userMapper.deleteByPrimaryKey(user);
        if (i == 0) {
            return ResponseResult.FAILED("删除失败");
        } else {
            return ResponseResult.SUCCESS("删除成功");
        }
    }

    /**
     * 根据用户ID 查询用户
     *
     * @param userId
     * @return
     */
    private User getUserById(long userId) {
        User user1 = new User();
        user1.setUserId(userId);
        return userMapper.selectByPrimaryKey(user1);
    }

    /**
     * 修改用户
     *
     * @param userId
     * @param user
     * @return
     */
    @Override
    public ResponseResult modifyUser(long userId, User user) {
        User user1 = getUserById(userId);
        if (user1 == null) {
            return ResponseResult.FAILED("No corresponding user");
        }
        user.setUserId(userId);
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i == 0) {
            return ResponseResult.FAILED("Modification failed");
        } else {
            return ResponseResult.SUCCESS("Modified successfully");
        }
    }

    /**
     * 获取用户
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseResult getUser(long userId) {
        User userById = getUserById(userId);
        if (userById == null) {
            return ResponseResult.FAILED("No corresponding user");
        }
        return ResponseResult.SUCCESS("Get user successfully").setData(userById);
    }

    /**
     * 查询用户列表
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public ResponseResult getUserList(int page, int size) {
        List<User> users = userMapper.selectAll();
        return ResponseResult.SUCCESS("Query user list succeeded").setData(users);
    }

    /**
     * 获取管理员信息
     *
     * @param adminId
     * @return
     */
    @Override
    public ResponseResult getUserAdmin(long adminId) {
        Administrator administrator = new Administrator();
        administrator.setAdministratorId(adminId);
        Administrator administrator1 = administratorMapper.selectByPrimaryKey(administrator);
        if (administrator1 == null) {
            return ResponseResult.FAILED("No corresponding administrator");
        }
        return ResponseResult.SUCCESS("Query administrator succeeded").setData(administrator1);
    }

    /**
     * 添加家庭
     *
     * @param family
     * @return
     */
    @Override
    public ResponseResult addFamily(Family family) {
        Family family1 = familyMapper.selectByPrimaryKey(family);
        if (family1 != null) {
            return ResponseResult.FAILED("The home ID already exists. Please replace the home ID");
        }
        familyMapper.insert(family);
        return ResponseResult.SUCCESS("Family added successfully");
    }

    /**
     * 删除家庭
     *
     * @param familyId
     * @return
     */
    @Override
    public ResponseResult deleteFamily(long familyId) {
        Family family = new Family();
        family.setFamilyId(familyId);
        Equipment equipment1 = new Equipment();
        equipment1.setFamilyId(familyId);
        List<Equipment> equipmentList = equipmentMapper.select(equipment1);
        for (Equipment equipment : equipmentList) {
            furnitureService.deleteEquipment(equipment.getEquipmentId());
        }
        User user = new User();
        user.setFamilyId(familyId);
        userMapper.delete(user);
        int i = familyMapper.deleteByPrimaryKey(family);
        if (i == 0) {
            return ResponseResult.FAILED("Deletion failed");
        } else {
            return ResponseResult.SUCCESS("Delete succeeded");
        }
    }

    /**
     * 修改家庭
     *
     * @param family
     * @param familyid
     * @return
     */
    @Override
    public ResponseResult modifyFamily(Family family, long familyid) {
        family.setFamilyId(familyid);
        Family family1 = familyMapper.selectByPrimaryKey(family);
        if (family1 == null) {
            return ResponseResult.FAILED("No corresponding family");
        }
        familyMapper.updateByPrimaryKeySelective(family);
        return ResponseResult.SUCCESS("Successfully modified");
    }

    /**
     * 获取家庭
     *
     * @param familyId
     * @return
     */
    @Override
    public ResponseResult getFamily(long familyId) {
        Family family = new Family();
        family.setFamilyId(familyId);
        Family familyFromDB = familyMapper.selectByPrimaryKey(family);
        if (familyFromDB == null) {
            return ResponseResult.FAILED("No corresponding family");
        }
        return ResponseResult.SUCCESS("Get success!!").setData(familyFromDB);
    }

    /**
     * 获取家庭列表
     *
     * @return
     */
    @Override
    public ResponseResult getFamilyList() {
        List<Family> families = familyMapper.selectAll();
        return ResponseResult.SUCCESS("Get success!!").setData(families);
    }

    /**
     * @param adminId
     * @param administrator
     * @return
     */
    @Override
    public ResponseResult modifyAdmin(long adminId, Administrator administrator) {
        Administrator administrator2 = new Administrator();
        administrator2.setAdministratorId(adminId);
        Administrator administratorFromDb = administratorMapper.selectByPrimaryKey(administrator2);
        if (administratorFromDb == null) {
            return ResponseResult.FAILED("This administrator was not found");
        }
        administrator.setAdministratorId(adminId);
        administratorMapper.updateByPrimaryKey(administrator);
        return ResponseResult.SUCCESS("Modified successfully");
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    @Override
    public ResponseResult listUser() {
        List<User> users = userMapper.selectAll();
        return ResponseResult.SUCCESS().setData(users);
    }
}
