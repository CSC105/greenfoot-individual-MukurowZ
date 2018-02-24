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
        anim = new Animation("Entities/Missile/MissileRight", 4, 70, 44); 
        setImage(anim.getFrame());
        setObjSpeed(speed);
    }
    
    public void act() 
    {
        moveLeft();
        preDelete();
        setImage(anim.getFrame());
    }    
    
    // When is at edge
    public void preDelete()
    {
        if( getX() <= 15)
        {
            getWorld().removeObject(this);
        }
    }
}
