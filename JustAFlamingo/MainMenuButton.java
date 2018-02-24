import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenuButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenuButton extends GameUI
{
    /**
     * Act - do whatever the MainMenuButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MainMenuButton()
    {
          GreenfootImage menu = new GreenfootImage("UI/mainmenu.png");
          menu.scale(960,78);
          setImage(menu);
    }
    public void act() 
    {
        if(Greenfoot.getMouseInfo() != null && Greenfoot.mousePressed(this) )
        {
            Greenfoot.setWorld(new Main_menu());
        }
    }    
}
