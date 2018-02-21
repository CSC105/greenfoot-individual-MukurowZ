import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controller extends Actor
{
    /**
     * Act - do whatever the Controller wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Characters player;
    public Controller(Characters player){
        this.player = player;  
    }
    public void act()
    {
        /*if(Greenfoot.isKeyDown("Left")){
            player.setLocation( getX() - player.getSpeed(), getY() );
            player.moveLeft();
            player.setAnimation(player.getWalkingLeft());
        }
        if(Greenfoot.isKeyDown("Up")){
            player.moveJump();
        }
        if(Greenfoot.isKeyDown("Right")){
            player.moveRight();
            player.setAnimation(player.getWalkingRight());
        }*/
    }    
}
