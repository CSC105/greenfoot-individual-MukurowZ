import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Leaderboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leaderboard extends MainUI
{
    /**
     * Act - do whatever the Leaderboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.getMouseInfo() != null && Greenfoot.mousePressed(this) )
        {
            
        }
    }    
    public Leaderboard()
    {
        GreenfootImage Play = new GreenfootImage("UI/Mainleaderboard.png");
        Play.scale(390,96);
        setImage(Play);
    }    
}
