package com.company;

/*
  Description: The class will hold information regarding a weapon

  @Author: Hovan Lee
  @Version: June 14, 2021
*/

// Import the Math class
import java.lang.Math;

class Weapon { // Start of Weapon
    // Stores the name of a weapon
    private String strName;
    // Stores the amount of damage this weapon can do
    private float fltAmountOfDamage;
    // Stores the accuracy of the weapon
    private byte bytAccuracy;
    // Stores the number of hits done by the weapon
    private byte bytNumHits;


    /*
      Description: This is the constructor for a weapon
      @Author: Hovan Lee
      @Date: June 14, 2021
    */
    Weapon (String strName, float fltAmountOfDamage, byte bytAccuracy, byte bytNumHits)
    {
        this.strName = strName;
        this.fltAmountOfDamage = fltAmountOfDamage;
        this.bytAccuracy = bytAccuracy;
        this.bytNumHits = bytNumHits;
    } // End of the weapon's typical constructor
    Weapon ()
    {
        this.strName = "Unknown";
        this.fltAmountOfDamage = (byte)0;
        this.bytAccuracy = (byte)0;
        this.bytNumHits = (byte)0;
    } // End of the weapon's default constructor


    /*
      Description: These are the get methods for attributes of the weapon
      @Author: Hovan Lee
      @Date: June 14, 2021
    */
    public String getWeaponName ()
    {
        return this.strName;
    } // End of getWeaponName
    public float getAmountOfDamage ()
    {
        return this.fltAmountOfDamage;
    } // End of getAmountOfDamage
    public byte getAccuracy ()
    {
        return this.bytAccuracy;
    } // End of getAccuracy
    public byte getNumHits ()
    {
        return this.bytNumHits;
    } // End of getNumHits


    /*
      Description: This is the set method for a weapon's AmountOfDamage
      @Author: Hovan Lee
      @Date: June 14, 2021
    */
    public void setAmountOfDamage (float fltAmountOfDamage)
    {
        this.fltAmountOfDamage = fltAmountOfDamage;
    } // End of setAmountOfDamage


    /*
      Description: This method determines whether the weapon hit the target
      @Author: Hovan Lee
      @Date: June 14, 2021
    */
    public boolean hit ()
    {
        // Checks if a random number is smaller than or equal to the
        // accuracy, if yes then it was a succesful hit
        return Math.floor((Math.random()*99)+1) <= this.bytAccuracy;
    } // End of hit


    /*
      Description: Raises the weapon's stats based on the current floor
      @Author: Hovan Lee and Shirley Nguyen
      @Date: June 16, 2021
    */
    public void modifyWeapon()
    {
        // Increase the stats of a weapon based on the level
        for (int i = 0; i < Math.floor(Main.lvlBuilder.getNumberOfBlocks()/5); i++)
        {
            // Checks if accuracy will be increased
            if ((byte)Math.floor(Math.random()*2) == 0 && this.bytAccuracy < 100)
            {
                this.bytAccuracy = (byte)(this.bytAccuracy+5);
            } // End of increasing the accuracy
            // Damage will be increased
            else
            {
                this.fltAmountOfDamage = (float)(this.fltAmountOfDamage+5);
            } // End of increasing the damage
        } // End of increasing the stats of a weapon

        //Setting the accuracy to 100% if it goes over 100
        if(this.bytAccuracy > 100)
        {
            this.bytAccuracy = (byte)100;
        } // End of
    }


    /*
      Description: This method will output the data in weapon in an easy to read manner
      @Author: Hovan Lee
      @Date: June 14, 2021
    */
    public String toString ()
    {
        return "Weapon Name: " + this.strName +
                "\nWeapon Damage: " + this.fltAmountOfDamage +
                "\nWeapon Accuracy: " + this.bytAccuracy + "%" +
                "\nWeapon's Number of Hits: " + this.bytNumHits;
    } // End of hit
} // End of Weapon