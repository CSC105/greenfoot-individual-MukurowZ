import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Playing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Playing extends World
{

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
   
}
