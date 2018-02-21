import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MissileRight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MissileRight extends Missile
{
    /**
     * Act - do whatever the MissileRight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Animation anim;
    Missile missile = new Missile();
    public MissileRight(int speed)
    {
        anim = new Animation("Entities/Missile/MissileRight", 3, 120, 64);
        setImage(anim.getFrame());
        missile.setObjSpeed(speed);
    }
    
    public void act() 
    {
        move();
        setImage(anim.getFrame());
    }    
    
    public void move()
    {  
        setLocation(getX() - missile.getObjSpeed(), getY());
    }
}
