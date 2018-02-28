import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gameover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gameover extends GameUI
{
    /**
     * Act - do whatever the Gameover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage gameover = new GreenfootImage("UI/Gameover.png");
    
    GreenfootSound sad = new GreenfootSound("Effect/sad.mp3");
    
    public Gameover()
    {
        sad.setVolume(30);
        gameover.scale(350,350);
        setImage(gameover);
        sad.play();
    }
    public void act() 
    {
        setImage(gameover);
    }    
}
