
int lightsensor()//Recieve and deal with the signal from lightsensor
{
  lightness = analogRead(0); //Connect grayscale sensor to Analog 0
  servo_9.write(180-lightness*0.1);//Write the value of angle adjusted by the brightness to servo_9
  return lightness;
  
}
