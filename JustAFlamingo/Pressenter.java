import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pressenter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pressenter extends MainUI
{
    /**
     * Act - do whatever the Pressenter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public void act() 
    {
        if(Greenfoot.getMouseInfo() != null && Greenfoot.mousePressed(this) )
        {
            Greenfoot.setWorld(new Playing());
        }
        else if(Greenfoot.isKeyDown("enter") )
        {
            Greenfoot.setWorld(new Playing());
        }
    }    
    public Pressenter()
    {
        GreenfootImage Play = new GreenfootImage("UI/Mainpressenter.png");
        Play.scale(960,69);
        setImage(Play);
    }     
}
