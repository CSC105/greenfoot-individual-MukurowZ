import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Characters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Characters extends Actor
{
    /**
     * Act - do whatever the Characters wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int speed = 7;
    private int jumpPower = 20;
    private int fallSpeed = 0;
    private int acceleration = 2;
    
    private Animation anim;
    public Characters(){
      anim = new Animation("Birds/FlamingoWalkRight/Flamingo", 36, 96, 156);
      setImage(anim.getFrame());
    }
    public void act() 
    {
        
        
       if(Greenfoot.isKeyDown("left") )
       {
           setImage(anim.getFrame());
           moveLeft();
       }
       else if(Greenfoot.isKeyDown("right") )
       {
           setImage(anim.getFrame());
           moveRight();
       }
        
       if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("space") )
       {
           setImage(anim.getFrame());
           moveJump();
       }
       else
       {
       //GreenfootImage mains = new GreenfootImage("Birds/FlamingoWalkRight/Flamingo1.png");
       //mains.scale(96, 156);
       //setImage(mains);
       }
       checkFall();
       
    }    
    /*
    public void move()
    {
        
    }
    */
 
    public void moveLeft()
    {
        setLocation( getX() - speed, getY() );
    }
    
    public void moveRight()
    {
        setLocation( getX() + speed, getY() );
    }
    
    public void moveJump()
    {
        setLocation( getX(), getY() - jumpPower );
    }
 
    public void fall()
    {
        setLocation( getX(), getY() + fallSpeed);
        fallSpeed = fallSpeed + acceleration;
    }
    
    public void checkFall()
    {
        if( onGround() )
        {
            fallSpeed = 0;
        }
        else
            fall();
    }
    
    public boolean onGround()
    {
        int height = getImage().getHeight();
        int lookForGround = (int)(height/2)+5;
        Actor under = getOneObjectAtOffset( 0, lookForGround  , Grass.class);
        return under != null;
    }
}

