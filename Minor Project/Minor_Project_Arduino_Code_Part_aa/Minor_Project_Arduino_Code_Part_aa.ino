//minor project arduino code part a.a
// goal is to automatically water a plant. 

#include <Arduino.h>


#define MOSFET 2 //mosfet for the water pump on digital I/O
#define MOISTURE A1 //moisture sensor on A1
#define WET_THRESH 600 //below 600 is considered wet


int moistureValue = 0; //initialize the moisture value

void setup() {
  Serial.begin(9600);
  pinMode(MOSFET, OUTPUT); // sets pin D2 to output (Mosfet/pump pin)
  digitalWrite(MOSFET, LOW); //sets pump to initially off


  
}

void loop() {

  moistureValue = analogRead(MOISTURE); //reads moisture from the sensor

  if(moistureValue < WET_THRESH){

    digitalWrite(MOSFET,LOW);
  }
  else{
    digitalWrite(MOSFET,HIGH);
    
  }

 
}
