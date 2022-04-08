#This is a python script to automatically read data from hardware and send them to database

import serial  # import serial package
import time  # import time package
import pymysql  # mport pymysql package

log = 0  # set a log variable to record the times of single reception
s = serial.Serial('com6', 9600, timeout=600)  # open the serial port, and configure the serial port parameters to be consistent with the communication parameters of your device.q
db = pymysql.connect(host="127.0.0.1",user= "root",password= "shifengnanshen", database="smarthome")  # open the database and configure the database
cursor = db.cursor()  # database operation

n = s.readline()  # reads a row of data from the serial port
print(n)  # print results on the console
while True:  # infinite loop reading data
    localtime = time.asctime(time.localtime(time.time()))  # time package operation, print local time
    n = s.readline()  # reads a row of data from the serial port
    print(n)  # print results on the console
    log += 1  # transmission times record + 1
    data = str(n)  # force string format
    local_time = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())  # regularizes the format of local time
    equipment_id = int(data[2:7])
    print(equipment_id)

    # following is classify data depended by the equipment id and add data into database
    if equipment_id == 10001 :
        hum = float(data[8:12])  # classification takes valid data
        temp = float(data[13:17])
        print(hum)
        sql = "UPDATE `smarthome`.`sensor` SET `measure_time` = '%s',`temperature`='%f',`humidity`='%f' WHERE(`equipment_id`='%d')"% (
        local_time,temp, hum, equipment_id,)

    elif equipment_id == 10002:
        brightness = int(data[8])
        if brightness ==0:
            sql = "UPDATE `smarthome`.`bulb` SET `measure_time` = '%s',`Ifopen`='0',`brightness`='%d' WHERE(`equipment_id`='%d')" % (
                local_time, brightness, equipment_id,)
        else:
            sql = "UPDATE `smarthome`.`bulb` SET `measure_time` = '%s',`Ifopen`='1',`brightness`='%d' WHERE(`equipment_id`='%d')" % (
                local_time, brightness, equipment_id,)

    elif equipment_id == 10003:
        ifopen = data[8:15]
        print(ifopen)
        if ifopen=='opening':
            sql = "UPDATE `smarthome`.`door&window` SET `measure_time` = '%s',`Ifopen`='1' WHERE(`equipment_id`='%d')" % (
            local_time, equipment_id,)
        else:
            sql = "UPDATE `smarthome`.`door&window` SET `measure_time` = '%s',`Ifopen`='0' WHERE(`equipment_id`='%d')" % (
                local_time, equipment_id,)
    cursor.execute(sql)  # execute database statement


    db.commit()  # commit

cursor.close()
db.close()