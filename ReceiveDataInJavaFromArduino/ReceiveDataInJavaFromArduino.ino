#include <Arduino.h>

 void setup () {
 // put your setup code here , to run once :
 pinMode ( DD6 , INPUT ) ; // button .
 Serial . begin (9600) ; // enable serial
 }

 void loop () {
 // put your main code here , to run repeatedly :
 if( digitalRead ( DD6 ) == HIGH ) {
 Serial . write (" Button !\n"); // button was pressed
 delay (400) ; // debouncing , long presses .
 }
 else {
 // nothing
 }

 if (! Serial . available () ) {
 return ;
 }
 }
