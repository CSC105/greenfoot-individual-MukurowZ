import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timecounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timecounter extends GameUI
{
    /**
     * Act - do whatever the Timecounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private long startTime;
    private long lastTimeChange;
    
    private TimeComponent bg;
    private TimeComponent centiSec1;
    private TimeComponent centiSec2;
    private TimeComponent sec1;
    private TimeComponent sec2;
    private TimeComponent min1;
    private TimeComponent min2;

    private TimeComponent colon1;  // sec: centiSec
    private TimeComponent colon2;  // min: sec
    
    private GreenfootImage[] setNum;
    public Timecounter(){
      super();
      startTime = System.nanoTime();
      lastTimeChange = startTime;
      
      setNum = new GreenfootImage[10];
      for(int i = 0; i < 10; ++i){
        setNum[i] = new GreenfootImage("Text/score-" + i + ".png" );  
      }
      
      GreenfootImage gray = new GreenfootImage( "UI/grayplate.png" );
      gray.scale(250, 64);
      bg = new TimeComponent( gray );
      
      centiSec1 = new TimeComponent( setNum[0] );
      centiSec2 = new TimeComponent( setNum[0] );
      sec1 = new TimeComponent( setNum[0] );
      sec2 = new TimeComponent( setNum[0] );
      min1 = new TimeComponent( setNum[0] );
      min2 = new TimeComponent( setNum[0] );
      
      colon1 = new TimeComponent( new GreenfootImage("Text/score-11.png") );
      colon2 = new TimeComponent( new GreenfootImage("Text/score-11.png") );
    }
    
    public void setToWorld(){
      getWorld().addObject(bg, 850, 60);
      getWorld().addObject(centiSec1, 936,60);
      getWorld().addObject(centiSec2, 909,60);
      getWorld().addObject(colon1, 882,60);
      getWorld().addObject(sec1, 855,60);
      getWorld().addObject(sec2, 828,60);
      getWorld().addObject(colon2, 801,60);
      getWorld().addObject(min1, 774,60);
      getWorld().addObject(min2, 747,60);
    }
    
    public void act(){
      if( System.nanoTime() - lastTimeChange > 10000000 ){
          setTime( toCentiSec( System.nanoTime() - startTime ) );
          lastTimeChange = System.nanoTime();
      }
    }
    
    public void setTime(long currentTime){
      int currentCentiSec1  = (int)(currentTime %10 /1);
      int currentCentiSec2  = (int)(currentTime %100/10);
      int currentSec1       = (int)(currentTime/100)%10;
      int currentSec2       = (int)(currentTime/100)%60/10;
      int currentMin1       = (int)(currentTime/6000)%10;
      int currentMin2       = (int)(currentTime/6000)%60/10;
      
      centiSec1.setCurrentImage( setNum[ currentCentiSec1 ] );
      centiSec2.setCurrentImage( setNum[ currentCentiSec2 ] );
      sec1.setCurrentImage( setNum[ currentSec1 ] );
      sec2.setCurrentImage( setNum[ currentSec2 ] );
      min1.setCurrentImage( setNum[ currentMin1 ] );
      min2.setCurrentImage( setNum[ currentMin2 ] );
      
    }
    
    public long toCentiSec(long nanoTime){
      return nanoTime/10000000;
    }
    
}
