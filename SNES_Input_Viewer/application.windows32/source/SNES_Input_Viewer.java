import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import org.gamecontrolplus.gui.*; 
import org.gamecontrolplus.*; 
import net.java.games.input.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SNES_Input_Viewer extends PApplet {





ControlIO control;
ControlDevice stick;

float YAXIS, XAXIS;
boolean  A, B, X, Y, LB, RB, ST, SL;

public void setup(){
  
  control = ControlIO.getInstance(this);
  stick = control.getMatchedDevice("SNES");
  
  if (stick == null){
    println("No controller");
    System.exit(-1);
  }
  
  
  background(0xffFF00E6);
  fill(200);
  noStroke();
  
  //Base
  rect(100,70,180,104);
  ellipse(100,130,120,120);
  ellipse(280,130,120,120);
  
  //Cross circle
  noFill();
  stroke(150);
  strokeWeight(2);
  ellipse(100,130,68,68);
  
  //Buttons Circle
  fill(150);
  noStroke();
  ellipse(280,130,104,104);
  
  
}

public void getUserInput(){
  
  YAXIS = map(stick.getSlider("YAXIS").getValue(),0,1,0,-1);
  XAXIS = map(stick.getSlider("XAXIS").getValue(),0,1,0,-1);
  A = stick.getButton("A").pressed();
  B = stick.getButton("B").pressed();
  X = stick.getButton("X").pressed();
  Y = stick.getButton("Y").pressed();
  LB = stick.getButton("LB").pressed();
  RB = stick.getButton("RB").pressed();
  ST = stick.getButton("ST").pressed();
  SL = stick.getButton("SL").pressed();
  
}

public void draw(){
  
  getUserInput();
  
  //Bumpers
  fill(200);
  rect(100,50,50,15);
  rect(230,50,50,15);
  
  //Cross
  fill(100);
  rect(79,123,14*3,14);
  rect(79+14,123-14,14,14*3);
  
  //Buttons
  //B
  fill (0xffC1B014);
  ellipse(280,130+24,25,25);
  
  //A
  fill(0xffC11414);
  ellipse(280+26,130,25,25);
  
  //X
  fill (0xff2514A7);
  ellipse(280,130-24,25,25);
  
  //Y
  fill(0xff34620F);
  ellipse(280-26,130,25,25);
  
  //Select & Start
  fill(100);
  ellipse(190-10,150,10,20);
  ellipse(190+10,150,10,20);
  
  
  //Cross
  if(YAXIS == 1){
    fill(0xff07EA05);
    rect(93,109,14,14);
  }
  
  if(YAXIS == -1){
    fill(0xff07EA05);
    rect(93,137,14,14);
  }
  
  if(XAXIS == 1){
    fill(0xff07EA05);
    rect(79,123,14,14);
  }
  
  if(XAXIS == -1){
    fill(0xff07EA05);
    rect(79+14*2,123,14,14);
  }
  
  //Buttons
  if ( A){
    fill (0xff07EA05);
  ellipse(280+26,130,25,25);
  }
  
  if ( B){
    fill (0xff07EA05);
  ellipse(280,130+24,25,25);
  }
  
  if ( X){
    fill (0xff07EA05);
  ellipse(280,130-24,25,25);
  }
  
  if ( Y){
    fill (0xff07EA05);
  ellipse(280-26,130,25,25);
  }
  
  if ( ST){
    fill (0xff07EA05);
  ellipse(190+10,150,10,20);
  }
  
  if ( SL){
    fill (0xff07EA05);
  ellipse(190-10,150,10,20);
  }
  
  //Bumpers
  if ( LB){
    fill (0xff07EA05);
  rect(100,50,50,15);
  }
  
  if ( RB){
    fill (0xff07EA05);
  rect(230,50,50,15);
  }
  
}
  public void settings() {  size(400,250); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SNES_Input_Viewer" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
