import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Playbutton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Playbutton extends MainUI
{
    /**
     * Act - do whatever the Playbutton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.getMouseInfo() != null && Greenfoot.mousePressed(this) )
        {
            Greenfoot.setWorld(new Playing());
        }
    }    
    public Playbutton()
    {
        GreenfootImage Play = new GreenfootImage("UI/Mainplay.png");
        Play.scale(390,96);
        setImage(Play);
    }
}
