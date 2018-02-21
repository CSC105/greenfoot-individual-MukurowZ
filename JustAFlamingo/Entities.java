import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Entities here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entities extends Actor
{
    /**
     * Act - do whatever the Entities wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    private int objSpeed;
    public Entities()
    {
        
    }
    public void act() 
    {
        
    }    

    public void moveLeft()
    {
        setLocation( getX() - speed, getY() );
    }
    
    public void moveRight()
    {
        setLocation( getX() + speed, getY() );
    }
    

}
