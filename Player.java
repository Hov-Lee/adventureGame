package com.company;

//Import from java library
import java.util.ArrayList;
import java.util.Random;
import java.text.DecimalFormat;
import java.lang.Math;
/*
 * This class stores player's information.
 * @author(Circe L)
 * @version (June 14, 2021)
 */
public class Player extends Actor
{
    //Instance variable
    private byte bytMaxCarryLimit;

    //Declare and initialize arrayList of type Weapon
    private ArrayList<Weapon> weaponList = new ArrayList<Weapon>();

    /*
     * Constructor to populate instance variables of player's class
     * @author(Circe L)
     * @version (June 14, 2021)
     */
    Player(String name, float health,Weapon weapon, byte speed, byte maxCarryLimit)
    {
        super(name, health, weapon, speed);
        this.weaponList.add(weapon);
        this.bytMaxCarryLimit = maxCarryLimit;
    }

    /*
     * Default constructor to populate instance variables of Player class in case nothing is sent in
     * @author(Circe L)
     * @version (June 14, 2021)
     */
    Player()
    {
        super();
        this.bytMaxCarryLimit = 0;
    }

    /*
     * Getter methods for all instance variables
     * @author(Circe L)
     * @version (June 14, 2021)
     */
    public String getPName()
    {
        return super.getName();
    }

    public float getPHealth()
    {
        return super.getHealth();
    }

    public Weapon getPWeapon()
    {
        return super.getHeldWeapon();
    }

    public byte getMCL()
    {
        return this.bytMaxCarryLimit;
    }

    public ArrayList <Weapon> getPWeaponList()
    {
        return this.weaponList;
    }

    public byte getPSpeed()
    {
        return super.getSpeed();
    }

    /*
     * Setter methods for all instance variables
     * @author(Circe L)
     * @version (June 14, 2021)
     */
    public void setMCL(byte MCL)
    {
        this.bytMaxCarryLimit = MCL;
    }

    public void setPName(String name)
    {
        super.setName(name);
    }

    public void setPHealth(float health)
    {
        super.setHealth(health);
    }

    public void setPWeapon(Weapon weapon)
    {
        super.setHeldWeapon(weapon);
    }

    public void setPSpeed(byte speed)
    {
        super.setSpeed(speed);
    }

    /*
     * Method to add weapons to the user inventory
     * @author(Circe L)
     * @version (June 14, 2021)
     */
    public void addWeapon(Weapon weaponToAdd)
    {
        //Declare variables for user input
        String strUserResponse;
        weaponToAdd.modifyWeapon();

        //Output weapon to add to user
        System.out.println("You found a weapon!\n\n" + weaponToAdd + "\n");
        strUserResponse = Generic.getString((byte)1, "Would you like to keep this weapon, yes or no: ", "yes","no");

        //If statement to check for user input
        if(strUserResponse.equalsIgnoreCase("yes"))
        {
            if(bytMaxCarryLimit == this.weaponList.size())
            {
                System.out.println();
                strUserResponse = Generic.getString((byte)1, "You can't add anymore weapons.\nWould you like to drop another weapon to take this one with you, yes or no: ", "yes", "no");

                if(strUserResponse.equalsIgnoreCase("yes"))
                {
                    Generic.printArrayList(this.weaponList);
                    System.out.println();
                    this.weaponList.set((byte)(Generic.getByte ((byte)1, "Which weapon would you like to exchange: ", (byte)1,(bytMaxCarryLimit))-1), weaponToAdd);
                    System.out.println ("Okay, weapon exchanged.");
                }
                else if(strUserResponse.equalsIgnoreCase("no"))
                {
                    System.out.println("Okay, weapon discarded.");
                }
            }
            else
            {
                this.weaponList.add(weaponToAdd);
                System.out.println ("Okay, weapon added.");
            }
        }
        else
        {
            System.out.println("Okay, weapon discarded.");
        }
    }

    /*
     * Method to give health to the player
     * @author(Circe L)
     * @version (June 14, 2021)
     */
    public void giveHealthItem()
    {
        //Declare random number for user's health
        Random rand = new Random();
        byte bytRandNum = (byte)(rand.nextInt((int)(20*(1+Math.floor(Main.lvlBuilder.getNumberOfBlocks()/5))))+1);

        //Call method to set user's health
        setPHealth((float)Math.floor((this.getPHealth() + bytRandNum)*100));
        setPHealth(this.getPHealth()/100);

        //Decimal format for up to two decimal places when outputing a number
        DecimalFormat df = new DecimalFormat("0.00");

        //Output to user
        System.out.println("You found " + bytRandNum + " health making your total health: " + df.format(this.getPHealth()));
    }

    /*
     * Override the toString method in the super class to output player's name, health, weapon, speed and      * carry limit
     * @author(Circe L)
     * @version (June 14, 2021)
     */
    @Override
    public String toString()
    {
        return  "Player name: " + this.getPName() + "\nHealth: " + this.getPHealth() + "\nSpeed: " + this.getPSpeed() + "\nCarry Limit: " + this.bytMaxCarryLimit + "\nHeld " + this.getPWeapon();
    }
}