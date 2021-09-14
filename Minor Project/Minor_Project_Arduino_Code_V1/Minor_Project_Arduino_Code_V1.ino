#include <Arduino.h>
#include <U8x8lib.h>
#define MOSFET 2 // The MOSFET driver for the water pump on digital I/O 2
#define REDLED 4 // Big red LED on digital I/O 4
#define BUTTON 6 // Push button on digital I/O 6
#define BUZZER 5// Buzzer on digital I/P 5
#define MOISTURE A1 //moisture sensor on A1
#define WET_THRESH 600

auto display = U8X8_SSD1306_128X64_NONAME_HW_I2C(U8X8_PIN_NONE);
int moistureValue = 0; 
int receivedData = 0;
void setup() {
 Serial.begin(9600);
 display.begin();
 display.setFlipMode(0);
 display.clearDisplay();
 display.setFont(u8x8_font_7x14B_1x2_r);
 pinMode(MOSFET, OUTPUT); // Sets the D2 pin (MOSFET + Pump) to output
 pinMode(REDLED, OUTPUT); // Sets the D4 pin (LED) to output
 pinMode(BUTTON, INPUT); // Sets the D6 pin (Button) to input
 pinMode(BUZZER,OUTPUT);

 digitalWrite(MOSFET, LOW); //sets pump to initially off

 
}

void sendMoistureData(){
  const auto value = analogRead(A1);
  const byte data [] = {0,0,highByte(value),lowByte(value)};
  Serial.write(data, 4); // send 0,0, "high byte", "low byte"
  Serial.println(); // send "newline"
}



void loop() {
 display.setFont(u8x8_font_7x14B_1x2_r);

 moistureValue = analogRead(MOISTURE); //reads moisture from the sensor

if(moistureValue > WET_THRESH){

    digitalWrite(MOSFET,HIGH);
    delay(200);
  }
  else if(moistureValue <WET_THRESH){
    digitalWrite(MOSFET,LOW);
  }

  
 sendMoistureData();
 
 display.setCursor(0, 0);
 //if (!Serial.available()) {return;}
 if(Serial.available() > 0)
 {
  
 
 receivedData = Serial.read();
 
 // format the data
// char buf[16];
/*
 int y= (int)(buf);
 sprintf(buf, "%03d", receivedData);
 */
 if(receivedData<=100){

  //display.setCursor(0,0);
  //display.print("connection test");
  //display.setCursor(0,5);
  //display.print(buf);
  digitalWrite(REDLED,LOW);
  digitalWrite(MOSFET,LOW);

  
 }
 else if (receivedData == 255)
 {
  digitalWrite(MOSFET,LOW);
  digitalWrite(REDLED,HIGH);
  
 }
 else {
  //display.print("error");
  //display.clearDisplay();
  digitalWrite(MOSFET,LOW);
  digitalWrite(REDLED,LOW);
 }
}

 
}
