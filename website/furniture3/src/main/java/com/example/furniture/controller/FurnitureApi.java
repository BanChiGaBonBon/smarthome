package com.example.furniture.controller;

import com.example.furniture.response.ResponseResult;
import com.example.furniture.services.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/furniture/")
/**
 * 家具API
 */
public class FurnitureApi {
    @Autowired
    private FurnitureService furnitureService;
    /**
     * 查询设备
     *
     * @param equipmentId
     * @return
     */
    @PostMapping("/{equipmentId}")
    public ResponseResult getEquipment(@PathVariable("equipmentId") long equipmentId) {
        return furnitureService.getEquipment(equipmentId);
    }

    /**
     * 根据家庭ID查询设备列表
     *
     * @param familyId
     * @return
     */
    @GetMapping("/list-f/{familyId}")
    public ResponseResult getEquipmentListByFamilyId(@PathVariable("familyId") long familyId) {
        return furnitureService.getEquipmentListByFamilyId(familyId);
    }
    /**
     * 查询设备列表
     *
     * @return
     */
    @GetMapping("/list")
    public ResponseResult getEquipmentList() {
        return furnitureService.getEquipmentList();
    }

    @PutMapping("/blub/add/{blubId}")
    public ResponseResult addBluBrightness(@PathVariable("blubId") long blubId) {
        return furnitureService.addBluBrightness(blubId);
    }
    @PutMapping("/blub/reduce/{blubId}")
    public ResponseResult reduceBluBrightness(@PathVariable("blubId") long blubId) {
        return furnitureService.reduceBluBrightness(blubId);
    }
}
