import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Playbutton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Playbutton extends GameUI
{
    GreenfootSound main = new GreenfootSound("Playtheme/Main.mp3");
    /**
     * Act - do whatever the Playbutton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.getMouseInfo() != null && Greenfoot.mousePressed(this) )
        {
            Greenfoot.setWorld(new Playing());
            main.stop();
        }
    }    
    public Playbutton()
    {
        main.setVolume(40);
        main.play();
        GreenfootImage Play = new GreenfootImage("UI/PlayButton.png");
        Play.scale(240,240);
        setImage(Play);
    }
}
