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
    
    // For animation
    private int currentFrame;
    private int allFrames;
    private String nameSprite;
    private GreenfootImage sprites;
    
    public void act() 
    {
       if(Greenfoot.isKeyDown("left") )
       {
           tryAnimation("Birds/FlamingoWalkLeft/Flamingo", 36, 96, 156);
           moveLeft();
       }
       else if(Greenfoot.isKeyDown("right") )
       {
           new Animation("Birds/FlamingoWalkRight/Flamingo", 36, 96, 156);
           moveRight();
       }
        
       if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("space") )
       {
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
    
    public void tryAnimation(String name, int allFrame, int width, int height)
    {
        for(int i = 1; i <= allFrame ; ++i)
        {
            sprites = new GreenfootImage(name+i+".png");
            sprites.scale(width,height);
            setImage(sprites);
        }
    }
   
 
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
        Actor under = getOneObjectAtOffset(0, 90  , Grass.class);
        return under != null;
    }
}

