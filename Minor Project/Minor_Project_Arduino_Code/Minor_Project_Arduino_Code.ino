//minor project arduino code
// goal is to automatically water a plant. 

#include <Arduino.h>
#include <U8x8lib.h> //library for led display

#define MOSFET 2 //mosfet for the water pump on digital I/O
#define BUTTON 6 // push button on digital I/O 6
#define MOISTURE A1 //moisture sensor on A1
#define WET_THRESH 600 //below 600 is considered wet

auto display = U8X8_SSD1306_128X64_NONAME_HW_I2C(U8X8_PIN_NONE);//creates the object for the display

int moistureValue = 0; //initialize the moisture value

void setup() {
  Serial.begin(9600);
  pinMode(MOSFET, OUTPUT); // sets pin D2 to output (Mosfet/pump pin)
  pinMode(BUTTON, INPUT); // sets pin D6 to input (button pin)
  digitalWrite(MOSFET, LOW); //sets pump to initially off

  display.begin();//starts up display

  // orienting display:
  display.setFlipMode(0);
  display.clearDisplay();
  display.setFont(u8x8_font_profont29_2x3_r);
  display.setCursor(0,0);
  
}

void loop() {

  moistureValue = analogRead(MOISTURE); //reads moisture from the sensor

  
}
