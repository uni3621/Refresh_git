#include <LiquidCrystal.h> // include LCD library (standard library)
#include <Keypad.h> // include keypad library - first you must install library (library link in the video description)

// number of the keypad's rows and columns
const byte rows = 4; 
const byte cols = 4;


char keyMap [rows] [cols] = { // define the cymbols on the buttons of the keypad

  {'1', '2', '3', 'A'},
  {'4', '5', '6', 'B'},
  {'7', '8', '9', 'C'},
  {'*', '0', '#', 'D'}
};

byte rowPins [rows] = {0, 2, 3, 4}; //pins of the keypad
byte colPins [cols] = {5, 6, 7, 8};

Keypad myKeypad = Keypad(makeKeymap(keyMap), rowPins, colPins, rows, cols);

LiquidCrystal lcd (A0, A1, A2, A3, A4, A5); // pins of the LCD. (RS, E, D4, D5, D6, D7)

void setup(){
  lcd.begin(16, 2); // 16 * 2 LCD module
  Serial.begin(9700);
}

// Set array variable
char Receivedkey[5];
char check[2];
char phone_number[13];

// Set integer variable
int j = 0; // check index
int i = 0; // password index
int k = 0; // ID index
int s = 0; // phone_number index
int x = 0; // total_index

// Set character variable
char *ID = "12345*"; // delivery agent ID
char FIN = '#';      // when close the box


char condition = 'C'; // request only once open
char lcd_condition_1 = 'T'; // first monitor
char lcd_condition_2 = 'T'; // second monitor
char lcd_condition_3 = 'T'; // third monitor

void loop(){
  char presskey = myKeypad.getKey(); //define which key is pressed with getKey
  
  if(presskey != 0){
   Serial.println(presskey);
  } 
  if(condition == 'C'){
      lcd.setCursor(0, 0); // fisrt line
      lcd.print("Delivery  ->  1*");
      lcd.setCursor(0, 1); // second line
      lcd.print("Recipient ->  2*");
  }
  if(Serial.available()){
   
    char in_data;
    in_data = Serial.read();
    if(in_data == 'D'){
      condition = 'D';
      lcd.clear();
      lcd.setCursor(0, 0);
      lcd.print(" Input your ID ");
      lcd.setCursor(0, 1);
      lcd.print(" then  Enter :* ");
    }
    if(in_data == 'U'){
      condition = 'U';
      lcd.clear();
      lcd.setCursor(0, 0);
      lcd.print(" Input your passwd ");
      lcd.setCursor(0, 1);
      lcd.print(" then  Enter :# ");
    }
    if(in_data == 'W'){
      condition = 'W';
      lcd.clear();
      lcd.setCursor(0, 0);
      lcd.print("NOT EXIESTED ID");
      lcd.setCursor(0, 1);
      lcd.print(" then  Enter :# ");
    }
    if(in_data == 'C'){
      condition = 'C';
      lcd.setCursor(0, 0); // fisrt line
      lcd.print("Delivery  ->  1*");
      lcd.setCursor(0, 1); // second line
      lcd.print("Recipient ->  2*");
    }
    if(in_data == 'P'){
      condition = 'P';
      lcd.setCursor(0, 0); // fisrt line
      lcd.print("input phone num");
      lcd.setCursor(0, 1); // second line
      lcd.print("then enter : #");
    }
  }
  
}
