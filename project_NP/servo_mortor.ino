#include<Servo.h>
Servo servo;
int angle = 0;

void setup()
{
  servo.attach(7);
  Serial.begin(9600);
}

void loop()
{
  if(Serial.available())
  {
    char in_data;
    in_data = Serial.read();
    if(in_data=='S')
    {
      servo.write(-90);
    //  if(angle == 180)
    //  {
     //   angle = 0;
      //}
    }
    else if(in_data == 'O')
    {
     servo.write(100);
    } 
   // servo.write(angle);
  }
}
