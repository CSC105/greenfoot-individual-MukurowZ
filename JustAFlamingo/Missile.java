import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Missile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missile extends Entities
{
    /**
     * Act - do whatever the Missile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    double miss;
    int speed;
    public void act() 
    {
        miss = Math.random();
        checkMiss();
    }    
    
    public void checkMiss()
    {
        if(miss >= 51)
        {
            MissileLeft missile = new MissileLeft(speed);
        }
    }
    
    public void speed()
    {
        
    }
}
