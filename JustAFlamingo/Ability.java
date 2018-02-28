import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skill here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ability extends Actor
{
    private boolean godMode;
    private int status;
    
    GreenfootImage[] ability = new GreenfootImage[3];

    public Ability()
    {
        ability[0] = new GreenfootImage("UI/Skill/Skill_use.png");
        ability[1] = new GreenfootImage("UI/Skill/Skill.png");
        ability[2] = new GreenfootImage("UI/Skill/Skill_cooldown.png");
        ability[0].scale(45, 45);
        ability[1].scale(45, 45);
        ability[2].scale(45, 45);
        status = 0;
    }

    public void act() 
    {
        if(getWorld().getObjects(Characters.class).size() != 0)
            move();
        else
            removeMe();
        setStatus(status);
        setImage(ability[status]);
    }

    public void move()
    {
        Actor character = (Actor)getWorld().getObjects(Characters.class).get(0);
        setLocation(character.getX(),character.getY()-130);
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public void removeMe()
    {
        getWorld().removeObject(this);
    }
}
