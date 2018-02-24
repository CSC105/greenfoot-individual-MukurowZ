import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RetryButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RetryButton extends GameUI
{
    /**
     * Act - do whatever the RetryButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public RetryButton()
    {
        GreenfootImage retry = new GreenfootImage("UI/Retrybutton.png");
        retry.scale(960,78);
        setImage(retry);
    }
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
}
