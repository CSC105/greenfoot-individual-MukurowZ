import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Main_menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main_menu extends World
{

    /**
     * Constructor for objects of class Main_menu.
     * 
     */
    public Main_menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 720, 1); 
        prepare();
        GreenfootImage main = new GreenfootImage("Wallpaper/Main.png");
        main.scale(960,720);
        setBackground(main);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Playbutton playbutton = new Playbutton();
        addObject(playbutton,480,400);
    }
}
