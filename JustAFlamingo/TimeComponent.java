import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TimeComponent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimeComponent extends GameUI
{
    /**
     * Act - do whatever the TimeComponent wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage currentImage;
    public TimeComponent(GreenfootImage image){
      currentImage = image;
      setImage(image);
    }
    public void setCurrentImage(GreenfootImage image){
      currentImage = image;
      setImage(image);
    }
}
