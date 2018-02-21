import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Playing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Playing extends World
{
    int objSpeed;
    double miss;
    /**
     * Constructor for objects of class Playing.
     * 
     */
    public Playing()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 720, 1); 
        setBackground("Map/Background.png"); 
        Grass grass = new Grass();
        addObject(grass,318,673);
        Grass grass2 = new Grass();
        addObject(grass,733,673);
        Characters characters = new Characters();
        addObject(characters,480,360);
        
    }
    public void act() 
    {
        miss = Math.random()*100;
        objSpeed = (int)Math.random()*10;
        checkMiss(objSpeed);
    }    
    
    public void checkMiss(int speed)
    {
        if(miss >= 99)
        {
            addObject((new MissileLeft(speed)),00,623);
        }
        else if(miss >= 98)
        {
            addObject((new MissileRight(speed)),960,623);
        }
        else
        {
        }
    }
}
