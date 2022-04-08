void lightbutton()//Change the brightness of the light when the buttom is pressed
{
  b1 = digitalRead(BUTTON);

  if ((b1 == HIGH) && (b2 == LOW)) {//Determine whether the button is pressed or not
    delay(500);//延时
    brightness = (long) ((brightness + 1)) % (long) (6);//Calculation of gear speed
  }
    Serial.print("10002 ");//Send information to the database
    Serial.println(brightness);
  analogWrite(LED_button,(brightness * 51));//The maximum value of the voltage is 255, which is divided into five grades
  //strip.setBrightness(brightness*6);
}
