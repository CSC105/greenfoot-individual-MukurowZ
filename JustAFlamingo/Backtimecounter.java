import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Backtimecounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Backtimecounter extends Timecounter
{
    /**
     * Act - do whatever the Backtimecounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Backtimecounter()
    {
        GreenfootImage backPlate = new GreenfootImage("UI/grayplate.png");
        backPlate.scale(250, 64);
        setImage(backPlate);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
