package com.example.furniture.services;

import com.example.furniture.pojo.Equipment;
import com.example.furniture.response.ResponseResult;

public interface FurnitureService {

    ResponseResult addEquipment(Equipment equipment, String type);

    ResponseResult deleteEquipment(Long equipmentId);

    ResponseResult modifyEquipment(long equipmentId, Equipment equipment);

    ResponseResult getEquipmentListByFamilyId(long familyId);

    ResponseResult getEquipment(long equipmentId);

    ResponseResult getEquipmentList();

    ResponseResult addBluBrightness(long blubId);

    ResponseResult reduceBluBrightness(long blubId);
}
