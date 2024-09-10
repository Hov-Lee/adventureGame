package com.company;

/*
 * Description: This class holds the information involving the actors(characters).
 *
 * @author (Shirley Nguyen)
 * @version (June 14, 2021)
 */

// Import java classes
import java.lang.Math;

public class Actor
{
    //declaring instance variables
    private String strName;
    private float fltHealth;
    private byte bytSpeed;
    private Weapon heldWeapon;
    
    /*
     * Description: Constructor to populate the instance variables of Actor class.
     *
     * @author (Shirley Nguyen)
     * @version (June 14, 2021)
     */
    Actor(String n, float h, Weapon w, byte s)
    {
        this.strName = n;
        this.fltHealth = h;
        this.heldWeapon = w;
        this.bytSpeed = s;
    }

    /*
     * Description: Default constructor to populate the instance variables of Actor class if nothing is sent in.
     *
     * @author (Shirley Nguyen)
     * @version (June 14, 2021)
     */
    Actor()
    {
        this.strName = "Unknown";
        this.fltHealth = 0f;
        this.heldWeapon = new Weapon();
        this.bytSpeed = 0;
    }

    /*
     * Description: Get methods for all the instance variables to access them since they're private.
     *
     * @author (Shirley Nguyen)
     * @version (June 14, 2021)
     */
    public String getName()
    {
        return this.strName;
    }

    public float getHealth()
    {
        return this.fltHealth;
    }

    public Weapon getHeldWeapon()
    {
        return this.heldWeapon;
    }

    public byte getSpeed()
    {
        return this.bytSpeed;
    }

    /*
     * Description: Set methods for all the instance variables to update private instance variables.
     *
     * @author (Shirley Nguyen)
     * @version (June 14, 2021)
     */
    public void setName(String n)
    {
        this.strName = n;
    }

    public void setHealth(float h)
    {
        this.fltHealth = h;
    }

    public void setHeldWeapon(Weapon w)
    {
        this.heldWeapon = w;
    }

    public void setSpeed(byte s)
    {
        this.bytSpeed = s;
    }

    /*
     * Description: Takes in the amount of damage character was hit with then subtracts it from the health.
     *
     * @author (Shirley Nguyen)
     * @version (June 14, 2021)
     */
    public void takeDamage(float fltdamage)
    {
        this.fltHealth = (float)Math.floor((this.fltHealth - fltdamage)*100);
        this.fltHealth = this.fltHealth/100;

        //setting the health equal to zero if it tries to go below 0
        if(this.fltHealth < 0)
        {
            this.fltHealth = 0;
        }
    }

    /*
     * Description: Outputs the actor's name, health, speed, and their held weapon.
     *
     * @author (Shirley Nguyen)
     * @version (June 14, 2021)
     */
    public String toString()
    {
        return "\nName: " +this.strName+ "\nHealth: " +this.fltHealth+ "\nSpeed: " +this.bytSpeed+ "\nHeld Weapon: " +this.heldWeapon;
    }
}