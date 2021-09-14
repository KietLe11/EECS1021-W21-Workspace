//Second, have a Java program detect the soil condition and send a command to
//the Arduino to water the plant.
#include <Arduino.h>


void setup() {
 
 Serial.begin(9600);
}

void sendMoistureData(){
  const auto value = analogRead(A1);
  const byte data [] = {0,0, highByte(value), lowByte(value)};
  Serial.write(data, 4);
  Serial.println();
}
void loop() {

  sendMoistureData();
  delay(1000);

}
