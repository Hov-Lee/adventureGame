package com.company;

/*
* This class stores the enemy's information
 * @author(Circe L)
 * @version (June 14, 2021)
 */
public class Enemy extends Actor
{
  /*
  * Constructor for all instance variables in the Enemy class 
  * @author(Circe L)
  * @version (June 14, 2021)
  */
  Enemy(String n, float h, Weapon w, byte s)
  {
    super(n, h, w, s);
  } 

  /*
  * Default constructor for all instance variables in the Enemy class if no information is sent in
  * @author(Circe L)
  * @version (June 14, 2021)
  */
  Enemy()
  {
    super();
  }

  /*
    Description: Raises the Enemy's stats based on the current floor
    @Author: Hovan Lee and Shirley Nguyen
    @Date: June 16, 2021
  */
  public void modifyEnemy()
  {
    // Increase the health based on the level
    for (int i = 1; i < Math.floor(Main.lvlBuilder.getNumberOfBlocks()/5); i++)
    {
      this.setEHealth(this.getEHealth()+20);
    } // End of increasing the health
    
    // Change the enemy's weapon as well
    this.getEWeapon().modifyWeapon();
  } // End of modifyEnemy

  /*
  * Getter methods for all instance variables in the Enemy class
  * @author(Circe L)
  * @version (June 14, 2021)
  */
  public String getEName()
  {
    return super.getName();
  }

  public float getEHealth()
  {
    return super.getHealth();
  }

  public Weapon getEWeapon ()
  {
    return super.getHeldWeapon();
  }

  public byte getESpeed()
  {
    return super.getSpeed();
  }

  /*
  * Setter methods for all instance variables in the Enemy class
  * @author(Circe L)
  * @version (June 14, 2021)
  */
  public void setEName(String name)
  {
    super.setName(name);
  }

  public void setEHealth(float health)
  {
    super.setHealth(health);
  }

  public void setEWeapon(Weapon weapon)
  {
    super.setHeldWeapon(weapon);
  }

  public void setESpeed(byte speed)
  {
    super.setSpeed(speed);
  }
}