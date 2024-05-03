import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  // variable for images
  PImage imgCurry;
  PImage imgCourt;

  // x and y 's
  float fltCurryX = 300;
  float fltCurryY = 200;

  float fltBallX = 200;
  float fltBallY = 100;

  float fltCourtX = -100;
  float fltCourtY = 0;

  // colour
  int black = color(0);
  int white = color(255);
  int magenta = color(255, 0 , 255);

  // speed
  float fltXSpeedCurry = 5;
  float fltYSpeedCurry = -5;

  float fltXSpeedBall = 2;
  float fltYSpeedBall = 2;

  // gravity
  double fltGravity = 0.5;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(0, 0, 0);
    
    // Load image of stephen
    imgCurry = loadImage("images.jpeg");
    
    // Resizing stephen image
    imgCurry.resize(imgCurry.width / 4, imgCurry.height / 4);

    // Load image background basketball court
    imgCourt = loadImage("iasdasd.jpeg");

    // Resizing basketball court image
    imgCourt.resize(imgCourt.width / 2, imgCourt.height);
  }

  public void draw() {
    // Make background white
    background(white);

    // Draw image background
    image(imgCourt, fltCourtX, fltCourtY);
    
    // Draw curry image
    image(imgCurry, fltCurryX, fltCurryY);

    // Move curry image
    fltCurryX += fltXSpeedCurry;
    fltCurryY += fltYSpeedCurry;

    // Border collision protection for curry
    if (fltCurryX > width - imgCurry.width || fltCurryX < 0) {
      fltXSpeedCurry *= -1;
     
    }    
    if (fltCurryY > height - imgCurry.height || fltCurryY < 0) {
      fltYSpeedCurry *= -1;
    }    
    
    // Draw circle
    fill(255, 68, 69);
    circle(fltBallX, fltBallY, 50);

    // Move ball
    fltBallX += fltXSpeedBall;
    fltBallY += fltYSpeedBall;

    // Create gravity when moving
    fltYSpeedBall += fltGravity;
   
    // Border collision for ball
    if (fltBallX > width - 25 || fltBallX < 25) {
      fltXSpeedBall *= -1;
     
    }    
    if (fltBallY > height - 25 || fltBallY < 25) {
      fltYSpeedBall *= -1;
    }    
    
  }
}