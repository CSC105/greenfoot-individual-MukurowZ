import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Millisec here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Millisec extends Timecounter
{
    /**
     * Act - do whatever the Millisec wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int millisec = getMillisec();
    private int FirstDigit;
    private int SecondDeigit;
    public void act() 
    {
        checkMillisec();
    }    
    
    public void checkMillisec()
    {
        if(millisec >= 10)
        {
            
        }
    }
}
