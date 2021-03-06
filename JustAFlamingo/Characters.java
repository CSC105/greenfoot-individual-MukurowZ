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
    Playing playWorld = (Playing)getWorld();
    Ability ability = new Ability();
    
    private int speed = 9;
    private int jumpPower = 27;
    private int fallSpeed = 0;
    private int acceleration = 2;
    private int maxJump = 2;
    private int jumpCount;
    private int cooldown;
    private int max_cooldown = 500;
    private int status = 0;
    // status 0 is ready
    // status 1 is use
    // status 3 is cooldown
    private short looped;
    private boolean jumping;
    private boolean falling;
    private boolean lefted = false;
    private boolean immortal;
    
    private boolean isFirstTime;

    private GreenfootImage anima;
    protected Animation walkingLeft;
    protected Animation walkingRight;
    protected Animation immortalLeft;
    protected Animation immortalRight;
    private Animation currentAnim;
    private Animation anim;
    
    GreenfootImage img;
    GreenfootImage mainRight = new GreenfootImage("Birds/FlamingoWalkRight/Flamingo1.png");
    GreenfootImage mainLeft = new GreenfootImage("Birds/FlamingoWalkLeft/Flamingo1.png");
    GreenfootImage imRight = new GreenfootImage("Birds/FlamingoWalkRight/Flamingo1.png");
    GreenfootImage imLeft = new GreenfootImage("Birds/FlamingoWalkLeft/Flamingo1.png");
    
    GreenfootSound theme1 = new GreenfootSound("Playtheme/Theme1.mp3"); 
    GreenfootSound jumpSound = new GreenfootSound("Characters/8bitJump.mp3");
    GreenfootSound godMode = new GreenfootSound("Characters/GOBBLE.mp3");
    GreenfootSound error = new GreenfootSound("Effect/error.mp3");

    public Characters(){
        setWalkingLeft( new Animation( "Birds/FlamingoWalkLeft/Flamingo", 36, 96, 156 ));
        setWalkingRight( new Animation( "Birds/FlamingoWalkRight/Flamingo", 36, 96, 156));
        setImmortalLeft( new Animation("Birds/FlamingoWalkLeft/Flamingo", 36, 96, 156));
        setImmortalRight( new Animation("Birds/FlamingoWalkRight/Flamingo", 36, 96, 156));
        for(int o = 0; o < 36; ++o)
        {   
            if(o%3==0)
            {
                setAnimation(getImmortalRight());
                img = (immortalRight.getFrame());
                img.setTransparency(70);
                setAnimation(getImmortalLeft());
                img = (immortalLeft.getFrame());
                img.setTransparency(70);
            }
            else
            {   
                setAnimation(getImmortalRight());
                img = (immortalRight.getFrame());
                setAnimation(getImmortalLeft());
                img = (immortalLeft.getFrame());
            }
        }
        status = 0;
        immortal = false;
        cooldown = 500;
        mainLeft.scale(96,156);
        mainRight.scale(96,156);
        imRight.scale(96,156);
        imLeft.scale(96,156);
        imRight.setTransparency(70);
        imLeft.setTransparency(70);
        jumpSound.setVolume(20);
        error.setVolume(30);
        godMode.setVolume(50);
        jumpSound.setVolume(25);
        setAnimation(getWalkingLeft());
        setImage(getWalkingLeft().getFrame());
    }

    public void act() 
    {
        if( getWorld() != null && isFirstTime == false ) {
            isFirstTime=true;
            getWorld().addObject(ability, 480, 240);
        }
        checkFall();
        if(!immortal)
        {
            checkKey();
            checkTouch();
            if( cooldown < max_cooldown && !godMode.isPlaying())
            {
                cooldown++;
                status = 2;
                ability.setStatus(2);
            }
            else
            {
                status = 0;
                ability.setStatus(0);
            }
        }
        else if(immortal)
        {
            checkKeyImmortal();
            if(!godMode.isPlaying())
            {
                status = 2;
                ability.setStatus(2);
                immortal = false;
            }
        }
        else{
            
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

    // When touch objects
    public void checkTouch()
    {
        if(isTouching(MissileRight.class) || isTouching(MissileLeft.class))
        {
            goToRetry();
            //ability.removeMe();
        }
    }

    // Go to retry screen
    public void goToRetry()
    {
        Greenfoot.playSound("Characters/hit1.wav");
        stopMusic();
        Greenfoot.delay(10);
        getWorld().removeObject(this);
    }

    // Check Keyboard
    public void checkKey()
    {
        if(Greenfoot.isKeyDown("left") && !isAtEdge())
        {
            setAnimation(getWalkingLeft());
            img = walkingLeft.getFrame();
            setImage(img);
            moveLeft();
            lefted = true;
        }
        else if(Greenfoot.isKeyDown("right") && getX() < 950)
        {
            setAnimation(getWalkingRight());
            img = walkingRight.getFrame();
            setImage(img);
            moveRight();
            lefted = false;
        }
        else
        {
            if(lefted)
                setImage(mainLeft);
            else
                setImage(mainRight);
        }

        if(Greenfoot.isKeyDown("up") && jumping == false)
        {
            moveJump();
        }

        if(Greenfoot.isKeyDown("s") && !immortal)
        {
            if(cooldown >= max_cooldown)
            {
                immortal = true;
                status = 1;
                ability.setStatus(1);   // immortal
                godMode.play();
                if( playWorld == null ) playWorld = (Playing) getWorld();
                cooldown = 0;
            }
            else 
                error.play();
        }
    }

    //God Mode
    public void checkKeyImmortal()
    {
        status = 1;
        ability.setStatus(1);
        if(Greenfoot.isKeyDown("left") && !isAtEdge())
        {
            setAnimation(getImmortalLeft());
            img = immortalLeft.getFrame();
            setImage(img);
            moveLeft();
            lefted = true;
        }
        else if(Greenfoot.isKeyDown("right") && getX() < 950)
        {
            setAnimation(getImmortalRight());
            img = immortalRight.getFrame();
            setImage(img);
            moveRight();
            lefted = false;
        }
        else if(Greenfoot.isKeyDown("s"))
        {
            error.play();
        }
        else
        {
            if(lefted)
                if(looped == 0)
                {
                    setImage(imLeft);
                    looped++;
                }
                else 
                {
                    setImage(mainLeft);
                    looped = 0;
                }
            else
                if(looped == 0)
                {
                    setImage(imRight);
                    looped++;
                }
                else 
                {
                    setImage(mainRight);
                    looped = 0;
                }
        }

        if(Greenfoot.isKeyDown("up") && jumping == false)
        {
            moveJump();
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
        jumpSound.play();
        fallSpeed = fallSpeed - jumpPower;
        jumping = true;
        fall();
        //Greenfoot.playSound("Characters/fallsmall.mp3");
    }

    //Falling System
    public void fall()
    {
        falling = true;
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
            jumpCount = 0;
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

    public void setImmortalLeft(Animation immortalLeft){
        this.immortalLeft = immortalLeft;
    }

    public void setImmortalRight(Animation immortalRight){
        this.immortalRight = immortalRight;
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

    public Animation getImmortalLeft(){
        return immortalLeft;
    }

    public Animation getImmortalRight(){
        return immortalRight;
    }
    
    public int getStatus(){
        return this.status;
    }
    /*
    public Animation getJumper(){
    return jumper;
    }
     */
}

