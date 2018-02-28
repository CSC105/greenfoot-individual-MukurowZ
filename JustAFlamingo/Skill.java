import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skill here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skill extends GameUI
{
    private boolean godMode;
    
    public Skill()
    {
        GreenfootImage skill1 = new GreenfootImage("UI/Skill/Skill.png");
        GreenfootImage skill2 = new GreenfootImage("UI/Skill/Skill_cooldown.png");
        skill1.scale(25, 25);
        setImage(skill1);
    }
    public void act() 
    {
        move();
    }
    
    public void move()
    {
        Actor character = (Actor)getWorld().getObjects(Characters.class).get(0);
        setLocation(character.getX(),character.getY()-130);
    }
}
