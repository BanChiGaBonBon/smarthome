//#include <DHT.h>
//#include <DHT_U.h>
#include <dht11.h>

#include <Servo.h>
#include <LiquidCrystal_I2C.h>
#include <Wire.h>

#include <IRremote.h>
#include <Servo.h>
#include <Adafruit_NeoPixel.h>
#define COLLISION_SENSOR 2  //Collision sensor
#define LED_alarm 7    //Alarm light
#define DHTPIN 8 //Temperature and humidity sensor
//#define DHTTYPE DHT11
//DHT dht(DHTPIN,DHTTYPE);
dht11 dht;
//#define SOUND_PIN 3//Sound sensor
#define LED_PIN 12//Voice control lamp
//#define PIN 7//Only valid interface
#define LED_button 6 //Buttom determining the LED light
#define BUTTON 3 //Buttom for other use （<----我不到啊）
#define fengmingqi 5//Alarm light
const int RECV_PIN = 11;//Identify digital pin for infrared sensor
int motori1 = 13;
int motori2 = 12;
int led_numbers = 8;
IRrecv irrecv(RECV_PIN);
//Adafruit_NeoPixel strip = Adafruit_NeoPixel(led_numbers, PIN, NEO_GRB + NEO_KHZ800);
LiquidCrystal_I2C lcd(0x27,16, 2);
decode_results results; 
//dht11 DHT11; //Initialize an object

volatile int b1;
volatile int b2;
volatile int brightness;
int lightness;            //1
boolean doorClose = true; //
int pos = 0;
Servo servo_9;
long time=0;
 float hum;
 float temp;
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600); //Use 9600 rate for serial communication
  irrecv.enableIRIn();
  temp_lcd_init();
  litsen_init();
  litbut_init();
  attachInterrupt(digitalPinToInterrupt(BUTTON),lightbutton,CHANGE);//Set interrupt to preform operation when the bottum is pressed
// attachInterrupt(digitalPinToInterrupt(COLLISION_SENSOR),alarm,FALLING);
   
}


void loop() {
  // put your main code here, to run repeatedly:
  temp_hum();
 alarm();
   lightsensor();
   lcd_th();
   //lightbutton();
  if (irrecv.decode(&results)) { //Check whether the infrared remote control signal is received
    Serial.println(results.value, HEX); //Output instruction information
    switch(results.value){//Change the state of LCD according to the Infrared signal
      case 0xFFA25D:     lcd_th();break;
      case 0xFF629D:/*if(!outdoor)*/lcd_door();break;
      case 0xFFE21D:lcd_light();break;
      case 0xFF22DD:/*voicelight();*/ analogWrite(0,HIGH);break;
      case 0xFF02FD://lightbutton();break;
      case 0xFFC23D:break;
      case 0xFFE01F:break;
      default:break;
      }   
    irrecv.resume();                 //Receive next instruction
  }

  //delay(500);
  //int lightness = lightsensor();
  //voicelight(); 
  //lightbutton();
 
  
}
void litsen_init()
{
   servo_9.attach(9, 500, 2500);//<---这个不知道是干嘛的
}

void temp_lcd_init()//Initialize LCD module for welcome word
{
  //data A4
  //clock A5
  //pinMode(DHTPIN,OUTPUT); 
  lcd.init();
  lcd.backlight();
  lcd.setCursor(0,0);
  lcd.print("welcome!");
  delay(200);
  lcd.clear();
  pinMode(motori1,OUTPUT);
  pinMode(motori2,OUTPUT);
}
void pins_init()//Initialize alarm module
{
    pinMode(LED_alarm,OUTPUT);
    turnOffLED();
    pinMode(COLLISION_SENSOR,INPUT);
    pinMode(fengmingqi,OUTPUT);
  
   //digitalWrite(4,LOW);
}
void voilit_init()//<---这个不知道是干嘛的
{
    pinMode(LED_PIN, OUTPUT);
}

void litbut_init()//Initialize brightness adjustment module module
{
    brightness = 0;
    b1 = 0; //new
    b2 = 0; //old
  
   pinMode(BUTTON, INPUT_PULLUP);
}

void lcd_door()//Initialize LCD module for state of the door
  lcd.clear();
  lcd.setCursor(0,0);
  if(doorClose)//Determine whether the window is closed
  {
    lcd.print("The door is ");
    lcd.setCursor(0,1);
     lcd.print("closed");
  }
  else
  {
    lcd.setCursor(0,0);
    lcd.print("The door is ");
    lcd.setCursor(0,1);
     lcd.print("opening!");
  }
    //delay(1000);
}

void lcd_light()//Initialize LCD module for brightness
{
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("The lightness is ");
  lcd.setCursor(0,1);
  lcd.print(lightness);
  delay(1000);
}
void lcd_th()//Initialize LCD module for humidity and temperature
{
  lcd.clear();
     lcd.setCursor(0,0);// top left
   lcd.print("Hum:");
   lcd.print(hum);
   lcd.print("%");
      lcd.setCursor(0,1); // bottom left
   lcd.print("Tem:");
   lcd.print(temp);
   lcd.print("oC");
     //delay(1000);
}
