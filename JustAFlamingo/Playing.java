import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Playing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Playing extends World
{
    private short count;
    private int objSpeed;
    private int status;
    private double miss;
    private boolean over;
 
    Characters characters = new Characters();
    Ability ability = new Ability();
    
    GreenfootSound theme1 = new GreenfootSound("Playtheme/Theme1.mp3");


    public Playing()
    {    
        super(960, 720, 1); 
        setOver(false);
        theme1.setVolume(20);
        setBackground("Map/Lake.png"); 
        Grass grass = new Grass();
        addObject(grass,318,673);
        Grass grass2 = new Grass();
        addObject(grass,733,673);
        prepare();
    }
    
    // Prepare
    public void prepare()
    {
        addObject(characters,480,360);
        addObject(ability, 480, 240);
        addClock();
        count = 0;
    }

    // add time counter
    public void addClock()
    {
        Timecounter timeCounter = new Timecounter();
        addObject( timeCounter, -100, -100 );
        timeCounter.setToWorld();
    }

    public void act() 
    {
        if(!over)
        {
            miss = Math.random()*100;
            objSpeed = (int)(Math.random()*10)+1;
            checkMiss(objSpeed);
            checkMusic();
            checkDied();
        }
        else if(over && count == 0)
        {
            count++;
            stopMusic();
            over();
        }
        else
        {

        }
    }   

    public void over()
    {
        Gameover over = new Gameover();
        addObject(over,500,200);
        RetryButton retry = new RetryButton();
        addObject(retry, 480, 480);
        MainMenuButton button = new MainMenuButton();
        addObject(button, 480, 620);
    }

    public void checkDied()
    {
        if(getObjects(Characters.class).size() == 0)
        {
            over = true;
            stopped();
        }
    }

    // Check themesound was play
    public void checkMusic()
    {
        if(!theme1.isPlaying() && over == false)
        {
            theme1.play();
        }
    }   
    //Stop music after die
    public void stopMusic()
    {
        if(theme1.isPlaying() && over == true)
        {
            theme1.stop();
        }
    }

    // Get & Set boolean Over
    public void setOver(boolean over)
    {
        this.over = over;
    }

    public boolean getOver()
    {
        return this.over;
    }

    // Spawn missile
    public void checkMiss(int speed)
    {
        if(miss >= 99.79997)
        {
            addObject((new MissileLeft(speed)),00,593);
        }
        else if(miss >= 98.9999)
        {
            addObject((new MissileRight(speed)),960,593);
        }
        else
        {

        }
    }
    /*
    public void addUsedSkill()
    {
        Ability ability = new Skill();
        addObject(skill, 0, 00);
    }
    
    public int checkStatus()
    {
        return characters.getGodMode();
    }
    
    public void setStatus()
    {
        
    }
    */
}
