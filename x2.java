//////// Exercise x2:  modularize exercise x1, and add dog to chase hero.
//////// Whoever Whoever  (CST 112; today's date?)

//////// Please change these to your name and today's date.
String author=  "David Marques";
String title=  "Monster Mash";
String help=  " Click to relocate hero \n 'q' to quit; 'r' to reset. ";


//// GLOBALS:  coordinates, speed, etc.
float horizon;
float x, y;       // Position.
float dx, dy;     // Speed.
float dogX, dogY;
float mouthR = 0;     //Mouth Rotation in PI



//// SETUP:  window size, initialization (start in middle of screen).
void setup() {
  size( 640,480);
  horizon=  height/4;
  x=  0;
  y=  0;
  dx=  0;
  dy=  0;
}



//// NEXT FRAME:  scene, action, show.
void draw() {
  scene();
  hero();
  dog();
  messages();
}




void scene() {  
  //// SCENE:  sky, sun, tree, house, etc.
  background( 100, 150, 200);                // sky
  fill( 255,255,0 );
  ellipse( width*3/4, height/8, 40, 40);    // sun
  
  fill( 100, 200, 100);
  stroke( 100, 200, 100);
  rect( 0, horizon, width, height*3/4);      // grass.
  
  triangle( 150, horizon-25, 120, horizon-75, 180, horizon-75);  // tree
  stroke( 139, 69, 19); fill( 139, 69, 19);  
  rect( 140, horizon-50, 20, 50);
  
  stroke(0); fill(0);
  ellipse( 145, horizon-70, 2, 2);              //Tree Smile :D
  ellipse( 155, horizon-70, 2, 2);
  arc(150, horizon-64 , 10, 10, 0, PI, CHORD);
  text( "Don't let him talk to you like that! You are a beautiful tree!", 10, horizon-80 );
    
  fill(255, 0, 150);
  rect( width/2-20, horizon-40, 40, 40);              // house
  fill(255, 0, 50);
  triangle( width/2, horizon-60, width/2-30, horizon-40, width/2+30, horizon-40);

  fill(0);
  text( "My name is Puckman, I live an evil life.", 10,height-20 );
  //--fill(255);text( "Created By David Marques", width-150, height-10);
  //--fill(0);
  
}



void messages() {
  fill(255);
  text( title, width/3, 20 );
  text( help, width*2/3, 30 );
  text( author, 10,height-10 );
}



//// ACTION:  move (x,y) coordinates of hero & dog; show them.
void hero() {
  if( x > width || x < 0){
    dx *= -1;                  //making left and right borders invert x direction
  }
  if( y > height || y < 0){    //making top and bottom borders invert y direction
    dy *= -1;
  }
  
  x=  x + dx;    // ACTION:  move (x,y) coordinates.
  y=  y + dy;  
  
  translate(x,y);                          //translates to x,y for the rotate
  rotate( atan2( y-dogY,x-dogX));          //
  
  text( "WOCCA!", 15, 0 );
  text( "Puckman", -30, -45);
  
  fill(255,200,0);
  if(frameCount % 20 < 10){      //Makes the mouth open and close every 20 frames
    mouthR = mouthR + (QUARTER_PI/10);    //Puckman Shape Close
  } else{
    mouthR = mouthR - (QUARTER_PI/10);    //Puckman Shape Open
  }
  arc(0, 0, 80, 80, mouthR, TWO_PI - mouthR, PIE);
  
  fill(255,255,255);               //White for Teeth and Eye
  line(0, -30, 10, -20);       //Puckman Eyebrow Line
  
  stroke(255, 0, 0);               //makes Teeth and Eye red           
  //triangle(0, 0, 5, -5, 5, 0);
  //triangle(5, 5, 10, 10, 10, 5);          //too lazy to include teeth in animation          
  //triangle(10, -10, 15, -15, 15, -10);    //Teeth
  //triangle(15, 15, 20, 20, 20, 15);    
  //triangle(20, -20, 25, -25, 25, -20);    
  
  ellipse(0, -20, 10, 10);        //Puckman Eye
  point(3, -20);                //Puckman Eye Pupil
  
  stroke(0);                       //makes stroke color black again
  rotate( -atan2( y-dogY,x-dogX));          //unrotates and untranslates the rest of the code
  translate(-x,-y);                         //
  
}



void dog() {
  dogX=  dogX - (dogX-x)/60;              //Movement of dog "Ghost"
  dogY=  dogY - (dogY-y)/80;
  
  fill(255);
  text( dogX, 10, 10 );                   //displays coords of "Dog"
  text( dogY, 10, 20 );
  //
  fill( 0, 255, 255 );
  rect(dogX-30,dogY-1, 60,50 );                //Body of dog "Ghost"
  arc(dogX, dogY, 60, 60, PI, TWO_PI, OPEN);   //Head of dog "Ghost"
  noStroke();
  
  fill(255);
  ellipse(dogX-13,dogY,15,15);                 //Whites of eyes of dog
  ellipse(dogX+13,dogY,15,15);
  
  fill(0,0,255);
  translate(dogX-13, dogY);                    //Left pupil rotation 
  rotate(atan2(y-dogY,x-dogX));                //towards location of Hero "Puckman"
  ellipse(4,0,7,7);
  rotate(-atan2(y-dogY,x-dogX));
  translate(-(dogX-13), -dogY);
  
  translate(dogX+13, dogY);                    //Right pupil rotation 
  rotate(atan2(y-dogY,x-dogX));                //towards location of Hero "Puckman"
  ellipse(4,0,7,7);
  rotate(-atan2(y-dogY,x-dogX));
  translate(-(dogX+13), -dogY);
  
  
}





//////// HANDLERS:  mouse clicks, keys
void mousePressed() {
  x=  mouseX;                             // Set (x,y) to mouse
  y=  mouseY;
  //
  dx=  random( -8, +8 );                  // random speed.
  dy=  random( -5, +5 );
}

void keyPressed() {
  if (key == 'q') {
    exit();                           // press 'q' key to QUIT.
  }
  /* INSERT YOUR CODE HERE! */
}
