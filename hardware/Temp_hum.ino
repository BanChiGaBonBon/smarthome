int temp_hum()//print the data of humidity and temperature to the LCD
{
  Serial.print("10001 "); //Output data from serial port
  int chk = dht.read(DHTPIN); //Assign the read value to chk
   hum = dht.humidity;
   //Serial.print("Humidity (%): ");
   Serial.print(hum, 2);//print humidity

   temp = dht.temperature;
   //Serial.print("Temperature (℃): ");
   Serial.println(temp, 2);//print temperature
  if(temp>36)
  {
    digitalWrite(motori1,HIGH); //Feed high level of voltage
    digitalWrite(motori2,LOW);  //Feed low level of voltage
  }else
  {
    digitalWrite(motori1,LOW); //Feed high level of voltage
    digitalWrite(motori2,LOW);  //Feed low level of voltage
  }


   
  return 1;
}
