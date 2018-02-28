import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MissileLeft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MissileLeft extends Missile
{
    /**
     * Act - do whatever the MissileLeft wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Animation anim;
    Missile missile = new Missile();
    public MissileLeft(int speed)
    {
        anim = new Animation("Entities/Missile/MissileLeft", 4,  70, 44);
        setImage(anim.getFrame());
        setObjSpeed(speed);
    }
    
    public void act() 
    {
        moveRight();
        preDelete();
        setImage(imgMissile);
    }    
       
    // When is at edge
    public void preDelete()
    {
        imgMissile = anim.getFrame();
        if(getWorld().getObjects(Characters.class).size() == 0)
        {
            imgMissile = anim.getFrame();
            imgMissile.setTransparency(0);
            setImage(imgMissile);
        }
        
        if( getX() >= 945)
        {
            getWorld().removeObject(this);
        } 
    }
}
