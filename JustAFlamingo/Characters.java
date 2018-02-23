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
    
    private int speed = 9;
    private int jumpPower = 27;
    private int fallSpeed = 0;
    private int acceleration = 2;
    private boolean jumping;
    
    private GreenfootImage anima;
    protected Animation walkingLeft;
    protected Animation walkingRight;
    //protected Animation jumper;
    private Animation currentAnim;
    private Animation anim;
    GreenfootSound theme1 = new GreenfootSound("Playtheme/Theme1.mp3"); 
    //GreenfootImage mains = new GreenfootImage("Birds/FlamingoWalkRight/Flamingo");
               
    public Characters(){
        setWalkingLeft( new Animation( "Birds/FlamingoWalkLeft/Flamingo", 36, 96, 156 ));
        setWalkingRight( new Animation( "Birds/FlamingoWalkRight/Flamingo", 36, 96, 156));
        /*setJumper( new Animation( "Birds/FlamingoWalkRight/Flamingo", 6, 96, 156));
        mains.scale(96, 156);*/
        
        setAnimation(getWalkingLeft());
        setImage(getWalkingLeft().getFrame());
    }
    public void act() 
    {
       checkFall();
       checkKey();
       checkTouch();
       checkWorld();
    }    
    
    
    // Check this is play world
    public void checkWorld()
    {
        if (getWorld() instanceof Playing)
        {
            checkMusic();
        }
    }
    //Stop music after die
    public void stopMusic()
    {
        if(theme1.isPlaying())
        {
            theme1.stop();
        }
    }
    
    // Check music
    public void checkMusic()
    {
        if(!theme1.isPlaying())
        {
            //theme1.play();
        }
    }

    // When touch objects
    public void checkTouch()
    {
        if(isTouching(MissileRight.class))
        {
            goToRetry();
        }
        if(isTouching(MissileLeft.class))
        {
            goToRetry();
        }
    }
    
    // Go to retry screen
    public void goToRetry()
    {
        Greenfoot.playSound("Characters/hit1.wav");
        stopMusic();
        Greenfoot.delay(50);
        Greenfoot.setWorld(new Retryscreen());
    }
    
    // Check Keyboard
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
       else
       {
           //setImage(mains);
       }
        
       if(Greenfoot.isKeyDown("up") && jumping == false)
       {
           moveJump();
           /*
           if(!Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right"))
           {
              setAnimation(getJumper());
              setImage(jumper.getFrame());
           }
           */
       }
       else
       {
           
       }
    }
    
    //Moving Method
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
        //Greenfoot.playSound("Characters/fallsmall.mp3");
    }
 
    //Falling System
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

    // Part of Animation System 
    public void setAnimation(Animation anim){
        this.currentAnim = anim;
    }
    // Animation Waling System
    public void setWalkingLeft(Animation walkingLeft){
        this.walkingLeft = walkingLeft;
    }
    public void setWalkingRight(Animation walkingRight){
        this.walkingRight = walkingRight;
    }
    /*
    public void setJumper(Animation jumping){
        this.jumper = jumper;
    }
    */
    // Get animation System
    public Animation getAnimation(){
        return currentAnim;  
    }
    public Animation getWalkingLeft(){
        return walkingLeft;
    }
    public Animation getWalkingRight(){
        return walkingRight;
    }
    
    /*
    public Animation getJumper(){
        return jumper;
    }
    */
}

