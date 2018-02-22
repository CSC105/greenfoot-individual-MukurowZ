import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Retryscreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Retryscreen extends World
{

    GreenfootSound retry = new GreenfootSound("Playtheme/Retry.mp3");
    public Retryscreen()
    {    
        super(960, 720, 1);
        GreenfootImage main = new GreenfootImage("Wallpaper/Maindotwallpaper.png");
        main.scale(960,720);
        setBackground(main);
        Pressenter pressenter = new Pressenter();
        addObject(pressenter , 480 , 650);
    }
    public void act()
    {
        checkMusic();
    }

    // Check themesound was play
    public void checkMusic()
    {
        if(!retry.isPlaying())
        {
            //retry.play();
        }
    }
    //Stop music after die
    public void stopMusic()
    {
        if(retry.isPlaying())
        {
            retry.stop();
        }
    }

}
