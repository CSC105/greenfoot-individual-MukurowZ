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
    private int jumpPower = 27;
    private int fallSpeed = 0;
    private int acceleration = 2;
    private boolean jumping;
    
    private GreenfootImage anima;
    protected Animation walkingLeft;
    protected Animation walkingRight;
    private Animation currentAnim;
    private Animation anim;
    public Characters(){
        setWalkingLeft( new Animation( "Birds/FlamingoWalkLeft/Flamingo", 36, 96, 156 ));
        setWalkingRight( new Animation( "Birds/FlamingoWalkRight/Flamingo", 36, 96, 156));
        
        setAnimation(getWalkingLeft());
        setImage(getWalkingLeft().getFrame());
    }
    public void act() 
    {
       checkFall();
       checkKey();
    }    
    /*
    public void move()
    {
        
    }
    */
    public void checkKey()
    {
       if(Greenfoot.isKeyDown("left") )
       {
           setAnimation(getWalkingLeft());
           setImage(walkingLeft.getFrame());
           moveLeft();
       }
       else if(Greenfoot.isKeyDown("right") )
       {
           setAnimation(getWalkingRight());
           setImage(walkingRight.getFrame());
           moveRight();
       }
        
       if(Greenfoot.isKeyDown("up") && jumping == false)
       {
           //setImage(anim.getFrame());
           moveJump();
       }
       else
       {
           /*GreenfootImage mains = new GreenfootImage("Birds/FlamingoWalkRight/Flamingo1.png");
           mains.scale(96, 156);
           setImage(mains);*/
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
        fallSpeed = fallSpeed - jumpPower;
        jumping = true;
        fall();
    }
 
    public void fall()
    {
        setLocation( getX(), getY() + fallSpeed);
        if(fallSpeed <= 9)
        {
            fallSpeed = fallSpeed + acceleration;
        }
        jumping = true;
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
        if(under == null)
        {
            jumping = true;
            return false;
        }
        else{
            moveToGround(under);
            return true;
        }
    }
    
    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        
        setLocation(getX(), newY);
        jumping = false;
    }


    public void setAnimation(Animation anim){
        this.currentAnim = anim;
    }
    
    public void setWalkingLeft(Animation walkingLeft){
        this.walkingLeft = walkingLeft;
    }
    public void setWalkingRight(Animation walkingRight){
        this.walkingRight = walkingRight;
    }
  
    public Animation getAnimation(){
        return currentAnim;  
    }
    
    public Animation getWalkingLeft(){
        return walkingLeft;
    }
    public Animation getWalkingRight(){
        return walkingRight;
    }
}

