package com.example.furniture.services;

import com.example.furniture.mapper.*;
import com.example.furniture.pojo.*;
import com.example.furniture.response.ResponseResult;
import com.example.furniture.utils.TextUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@Transactional
@Slf4j
public class FurnitureServiceImpl implements FurnitureService {
    @Autowired
    private SensorMapper sensorMapper;
    @Autowired
    private DoorWindowMapper doorWindowMapper;
    @Autowired
    private BulbMapper bulbMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private ManufacturerMapper manufacturerMapper;
    @Autowired
    private EquipmentTypeMapper equipmentTypeMapper;

    @Override
    public ResponseResult addEquipment(Equipment equipment, String type) {
        String name = equipment.getEquipmentName();
        String introduction = equipment.getEquipmentIntroduction();
        Long manufacturerId = equipment.getManufacturerId();
        Long familyId = equipment.getFamilyId();
        String equipmentType = equipment.getEquipmentType();
        if (TextUtils.isEmpty(name)) {
            return ResponseResult.FAILED("Missing device name!!");
        }
        if (TextUtils.isEmpty(introduction)) {
            return ResponseResult.FAILED("Missing device description");
        }
        if ("0".equals(String.valueOf(manufacturerId)) || "null".equals(String.valueOf(manufacturerId)) || manufacturerId <= 0) {
            return ResponseResult.FAILED("manufacturer ID need>=0");
        }
        if ("0".equals(String.valueOf(familyId)) || "null".equals(String.valueOf(familyId)) || familyId <= 0) {
            return ResponseResult.FAILED("family id need>=0");
        }
        if (TextUtils.isEmpty(equipmentType)) {
            return ResponseResult.FAILED("Device type cannot be empty");
        }
        Equipment equipment123 = equipmentMapper.selectByPrimaryKey(equipment);
        if (equipment123 != null) {
            return ResponseResult.FAILED("This ID is occupied");
        }
        EquipmentType equipmentType1 = new EquipmentType();
        equipmentType1.setEquipmentType(equipment.getEquipmentType());
        EquipmentType equipmentTypeFromDB = equipmentTypeMapper.selectByPrimaryKey(equipmentType1);
        if (equipmentTypeFromDB==null) {
            equipmentType1.setExisted(1L);
            equipmentTypeMapper.insert(equipmentType1);
        }
        int insert = equipmentMapper.insert(equipment);
        if (insert == 1) {
            if (type.equals("Sensor")) {
                Sensor sensor = equipment.getSensor();
                sensor.setEquipmentId(equipment.getEquipmentId());
                sensorMapper.insert(sensor);
            } else if (type.equals("Door or Window")) {
                DoorWindow doorWindow = equipment.getDoorWindow();
                doorWindow.setEquipmentId(equipment.getEquipmentId());
                doorWindowMapper.insertDW(doorWindow.getEquipmentId(),
                        doorWindow.getMeasureTime(),
                        doorWindow.getEquipmentType(),
                        doorWindow.getIfopen(),
                        doorWindow.getExisted());
            } else if (type.equals("Bulb")) {
                Bulb bulb = equipment.getBulb();
                bulb.setEquipmentId(equipment.getEquipmentId());
                bulbMapper.insert(bulb);
            }
        } else {
            return ResponseResult.FAILED("Add failed");
        }
        return ResponseResult.SUCCESS("Added successfully");
    }

    @Override
    public ResponseResult deleteEquipment(Long equipmentId) {
        if ("0".equals(String.valueOf(equipmentId)) || "null".equals(String.valueOf(equipmentId))) {
            return ResponseResult.FAILED("Please enter the correct device ID！");
        }
        Equipment equipment1 = new Equipment();
        equipment1.setEquipmentId(equipmentId);
        Equipment equipment = equipmentMapper.selectByPrimaryKey(equipment1);
        if (equipment == null) {
            return ResponseResult.FAILED("This device was not found");
        }
        int x = -999;
        int y = -999;
        String equipmentType = equipment.getEquipmentType();
        if (equipmentType.equals("Sensor")) {
            Sensor sensor = new Sensor();
            sensor.setEquipmentId(equipmentId);
            y = sensorMapper.deleteByPrimaryKey(sensor);
        } else if (equipmentType.equals("Door or Window")) {
            y = doorWindowMapper.deleteDW(equipmentId);
        } else if (equipmentType.equals("Bulb")) {
            Bulb bulb = new Bulb();
            bulb.setEquipmentId(equipmentId);
            y = bulbMapper.deleteByPrimaryKey(bulb);
        }
        x = equipmentMapper.deleteByPrimaryKey(equipment);
        if (x == 1 && y == 1) {
            return ResponseResult.SUCCESS("Successfully deleted！！");
        } else
            return ResponseResult.FAILED("No corresponding device");
    }

    @Override
    public ResponseResult modifyEquipment(long equipmentId, Equipment equipment) {
        Equipment equipmentFromDb = equipmentMapper.selectByPrimaryKey(equipmentId);
        if (equipmentFromDb == null) {
            return ResponseResult.FAILED("This device cannot be found");
        }
        int i = -999;
        equipment.setEquipmentId(equipmentId);
        equipmentMapper.updateByPrimaryKey(equipment);
        String type = equipmentFromDb.getEquipmentType();
        if (type.equals("Sensor")) {
            i = sensorMapper.updateByPrimaryKey(equipment.getSensor());
        } else if (type.equals("Door or Window")) {
            DoorWindow doorWindow = equipment.getDoorWindow();
            i = doorWindowMapper.updateDW(equipmentId,
                    doorWindow.getMeasureTime(),
                    doorWindow.getEquipmentType(),
                    doorWindow.getIfopen(),
                    doorWindow.getExisted());
        } else if (type.equals("Bulb")) {
            i = bulbMapper.updateByPrimaryKey(equipment.getBulb());
        }
        if (i == 0) {
            return ResponseResult.FAILED("Modification failed！！");
        }
        return ResponseResult.SUCCESS("Modified successfully");
    }
    @Override
    public ResponseResult getEquipmentListByFamilyId(long familyId) {
        Equipment equipment1 = new Equipment();
        equipment1.setFamilyId(familyId);
        List<Equipment> equipmentList = equipmentMapper.select(equipment1);
        getChildInfo(equipmentList);
        return ResponseResult.SUCCESS("Query list succeeded").setData(equipmentList);
    }

    @Override
    public ResponseResult getEquipment(long equipmentId) {
        Equipment equipment = equipmentMapper.selectByPrimaryKey(equipmentId);
        if (equipment == null) {
            return ResponseResult.SUCCESS("This device was not found");
        }
        String type = equipment.getEquipmentType();
        if (type.equals("Sensor")) {
            Sensor sensor1 = new Sensor();
            sensor1.setEquipmentId(equipmentId);
            Sensor sensor = sensorMapper.selectByPrimaryKey(sensor1);
            equipment.setDate(sensor);
        } else if (type.equals("Door or Window")) {
            DoorWindow doorWindow = doorWindowMapper.findById(equipmentId);
            equipment.setDate(doorWindow);
        } else if (type.equals("Bulb")) {
            Bulb bulb1 = new Bulb();
            bulb1.setEquipmentId(equipmentId);
            Bulb bulb = bulbMapper.selectByPrimaryKey(bulb1);
            equipment.setDate(bulb);
        }
        return ResponseResult.SUCCESS("get message Successfully!").setData(equipment);
    }

    @Override
    public ResponseResult getEquipmentList() {
        List<Equipment> equipments = equipmentMapper.selectAll();
        getChildInfo(equipments);
        return ResponseResult.SUCCESS("Query list succeeded").setData(equipments);
    }

    @Override
    public ResponseResult addBluBrightness(long blubId) {
        Bulb bulb = new Bulb();
        bulb.setEquipmentId(blubId);
        Bulb blubFromDB = bulbMapper.selectByPrimaryKey(bulb);
        if (blubFromDB == null) {
            return ResponseResult.FAILED("This bulb was not found");
        }
        Long brightness = blubFromDB.getBrightness();
        brightness = brightness + 1L;
        if (brightness >= 10) {
            brightness = 10L;
        }
        if (brightness > 0) {
            blubFromDB.setIfopen(1L);
        }
        blubFromDB.setBrightness(brightness);
        bulbMapper.updateByPrimaryKey(blubFromDB);
        return ResponseResult.SUCCESS("Brightness increase successful");
    }

    @Override
    public ResponseResult reduceBluBrightness(long blubId) {
        Bulb bulb = new Bulb();
        bulb.setEquipmentId(blubId);
        Bulb blubFromDB = bulbMapper.selectByPrimaryKey(bulb);
        if (blubFromDB == null) {
            return ResponseResult.FAILED("This bulb was not found");
        }
        Long brightness = blubFromDB.getBrightness();
        brightness -= 1L;
        if (brightness <= 0) {
            brightness = 0L;
        }
        if (brightness == 0) {
            blubFromDB.setIfopen(0L);
        }
        blubFromDB.setBrightness(brightness);
        bulbMapper.updateByPrimaryKey(blubFromDB);
        return ResponseResult.SUCCESS("Brightness reduction successful");
    }

    private void getChildInfo(List<Equipment> equipments) {
        for (Equipment equipment : equipments) {
            String type = equipment.getEquipmentType();
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setManufacturerId(equipment.getManufacturerId());
            Manufacturer manufacturer1 = manufacturerMapper.selectByPrimaryKey(manufacturer);
            equipment.setManufacturer(manufacturer1);
            if (type.equals("Sensor")) {
                Sensor sensor1 = new Sensor();
                sensor1.setEquipmentId(equipment.getEquipmentId());
                Sensor sensor = sensorMapper.selectByPrimaryKey(sensor1);
                equipment.setDate(sensor);
            } else if (type.equals("Door or Window")) {
                DoorWindow doorWindow = doorWindowMapper.findById(equipment.getEquipmentId());
                equipment.setDate(doorWindow);
            } else if (type.equals("Bulb")) {
                Bulb bulb1 = new Bulb();
                bulb1.setEquipmentId(equipment.getEquipmentId());
                Bulb bulb = bulbMapper.selectByPrimaryKey(bulb1);
                equipment.setDate(bulb);
            }
        }
    }
}
