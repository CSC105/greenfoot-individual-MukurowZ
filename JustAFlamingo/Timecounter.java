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
    GreenfootImage[] number = new GreenfootImage[12];

    private int millisec;
    private int seconds;
    private int minutes;
    
    public Timecounter()
    {
        for(int n = 0; n < 12; n++)
        {
            number[n] = new GreenfootImage("Text/score-"+ n + ".png"); 
        }
    }
    
    public void act() 
    {
        tick();
    }   
    
    public void tick()
    {
        millisec = millisec+1;
        seconds = millisec/100;
        minutes = minutes + seconds/60;
        millisec = millisec%100;
        seconds = seconds%60;
        minutes = minutes%60;
    }
    
    public int getMillisec()
    {
        return this.millisec;
    }
    public int getSeconds()
    {
        return this.seconds;
    }
    public int getMinutes()
    {
        return this.minutes;
    }
    
    
    public void timeMil()
    {
        
    }
    public void timeSec()
    {
        
    }
    public void timeMin()
    {
        
    }
    public void timeHour()
    {
        
    }

}
