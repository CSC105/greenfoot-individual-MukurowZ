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
    private int objSpeed;
    public Missile()
    {
        
    }
    public void act() 
    {
        /*miss = Math.random()*100;
        speed = (int)Math.random()*10;
        checkMiss(speed);
    }    
    
    public void checkMiss(int speed)
    {
        if(miss >= 66)
        {
            MissileLeft missile = new MissileLeft(speed);
        }
        else if(miss >= 33)
        {
            MissileRight missile = new MissileRight(speed);
        }
        else
        {
        }*/
    }
    
    public void setObjSpeed(int speed)
    {
        this.objSpeed = speed;
    }
    
    public int getObjSpeed()
    {
        return this.objSpeed;
    }
}
