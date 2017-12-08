float Watth=0.0;
float Time=0.0;
void setup() {
  Serial.begin(9600);  
}

void loop() {
  
  float AcsValue=0.0;
  float Samples=0.0;
  float AvgAcs=0.0;
  float Current=0.0;
  float Voltage=0.0;
  float Watt=0.0;
  for (int x = 0; x < 150; x++) {
    AcsValue = analogRead(A0);
    Samples = Samples + AcsValue;
  }
  
  AvgAcs = Samples / 150.0;
  Current = (2.5 - (AvgAcs * (5.0 / 1024))) / 0.185;
  Voltage = (analogRead(A0) / 1024.0) * 5000;
  Watt = (2490 - Voltage) * Current;
  Watth=Watt*(Time/3600);
  
  if (2490-Voltage > 0.0 && 2490-Voltage < 30.0) {
    
    /*Serial.print(Current);
    Serial.print(" A\n");
    Serial.print(2490-Voltage);
    Serial.print(" V\n"); 
    Serial.print(Watt);
    Serial.print(" W\n");
    */Serial.print(Watth);

  } else if (Current<0.1) {
    
      /*Serial.print("0.00");
      Serial.print(" A\n");
      Serial.print("0.00");
      Serial.print(" V\n"); 
      Serial.print("0.00");
      Serial.print(" W\n");
      */Serial.print("0.00");
  }
  delay(2000);
  Time+=2;
}
