import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Playing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Playing extends World
{
    int objSpeed;
    double miss;
    
    
    public Playing()
    {    
        super(960, 720, 1); 
        setBackground("Wallpaper/Greengrid.png"); 
        Grass grass = new Grass();
        addObject(grass,318,673);
        Grass grass2 = new Grass();
        addObject(grass,733,673);
        Characters characters = new Characters();
        addObject(characters,480,360);
        addClock();
        
    }
    public void addClock()
    {
       /* Back backtimecounter = new Back();
        FirstDigit first = new FirstDigit();
        SecondDigit second = new SecondDigit();
        ThirdDigit third = new ThirdDigit();
        FourthDigit fourth = new FourthDigit();
        FifthDigit fifth = new FifthDigit();
        SixthDigit sixth = new SixthDigit();
        colon colon = new colon();
        colon colon2 = new colon();
        addObject(backtimecounter, 850, 60);
        addObject(first, 936,60);
        addObject(second, 909,60);
        addObject(colon, 882,60);
        addObject(third, 855,60);
        addObject(fourth, 828,60);
        addObject(colon2, 801,60);
        addObject(fifth, 774,60);
        addObject(sixth, 747,60);*/
        Timecounter timeCounter = new Timecounter();
        addObject( timeCounter, -100, -100 );
        timeCounter.setToWorld();
    }
    
    public void act() 
    {
        miss = Math.random()*100;
        objSpeed = (int)(Math.random()*10)+1;
        checkMiss(objSpeed);
    }    
    /*
    // Check themesound was play
    public void checkMusic()
    {
        if(!theme1.isPlaying())
        {
            theme1.play();
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
    
    */
    
    public void checkMiss(int speed)
    {
        
        if(miss >= 99.79997)
        {
            addObject((new MissileLeft(speed)),00,600);
        }
        else if(miss >= 98.9999)
        {
            addObject((new MissileRight(speed)),960,600);
        }
        else
        {
            
        }
    }
}
