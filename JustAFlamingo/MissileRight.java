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
    public MissileRight()
    {
        anim = new Animation("Entities/Missile/MissileRight", 3, 120, 64);
        setImage(anim.getFrame());
    }
    public void act() 
    {
        setImage(anim.getFrame());
    }    
}
