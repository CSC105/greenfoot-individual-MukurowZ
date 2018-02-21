import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Descriptionplaybutton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Descriptionplaybutton extends GameUI
{
    /**
     * Act - do whatever the Descriptionplaybutton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.getMouseInfo() != null && Greenfoot.mousePressed(this) )
        {
            Greenfoot.setWorld(new Playing());
        }
    }    
    public Descriptionplaybutton()
    {
        GreenfootImage Play = new GreenfootImage("UI/Descriptionplaybutton.png");
        Play.scale(512,96);
        setImage(Play);
    }    
}
