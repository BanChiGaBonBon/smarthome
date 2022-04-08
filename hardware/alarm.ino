void alarm()//Alarm determined by whether the window is closed
{

  
  if(isTriggered())
    {
        digitalWrite(fengmingqi,LOW);//Turn off the alarm bell
        turnOffLED();//Turn off the alarm light
        doorClose=true;
        Serial.println("10003 closing");//Send information to the database
    }
   else {
    doorClose=false;
    lcd.clear();
       lcd.setCursor(0,0);
    lcd.print("The window is ");
    lcd.setCursor(0,1);
    lcd.print("opening!");//Send information to the LCD
    Serial.println("10003 opening");//Send information to the database
    for(int i=10;i>0;i--)//Turn on the alarm bell and light; let they preform in a cyclic change way
    {
     turnOnLED();    
     analogWrite(fengmingqi,200); 

     delay(50);
     turnOffLED();
      analogWrite(fengmingqi,50); 
     delay(50); 
    }
   
     }
}
boolean isTriggered()//Determine whether the window is closed or not
{
    if(!digitalRead(COLLISION_SENSOR))
    {
        delay(1);
        if(!digitalRead(COLLISION_SENSOR))
        return true;//The collision sensor triggers
    }
    return false;
}

void turnOnLED()//Turn on the LED
{
    digitalWrite(LED_alarm,HIGH);//The LED is on
}

void turnOffLED()//Turn off the LED
{
    digitalWrite(LED_alarm,LOW);//The LED is off
}
