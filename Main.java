package com.company;

/*
  Description: This program is an infinite adventure game where, you, the player ascends an infinite tower and fight enemies. The items and enemies you find along the way will have their stats boosted depending on what floor you're on.

  @Author: The whole group
  @Version: June 14, 2021
*/

// Import methods
import java.util.ArrayList;
import java.io.*;

class Main
{ // Start of Main
    // This is the master ArrayList of weapons
    public static ArrayList <Weapon> wpnList = new ArrayList <Weapon>();

    // This is the master ArrayList of enemies
    public static ArrayList <Enemy> enmList = new ArrayList <Enemy>();

    //This is the master ArrayList of Player types
    public static ArrayList <Player> plrList = new ArrayList<Player>();

    // Main instance of the level builder class.
    public static LevelBuilder lvlBuilder;

    // Stores the player's character
    public static Player plrUser;

    // Stores whether the game is over
    public static boolean bolIsGameOver = false;

    /*
      Description: This is the main method
      @Author: The whole group
      @Date: June 14, 2021
    */
    public static void main (String[] args) { // Start of main
        // Initialize the lists
        initiliazeWeapons();
        initializeEnemies();
        initializePlayer();

        // Initializing the phrase lists in the Block class
        Block.hpInitializePhrases();
        Block.wpnInitializePhrases();

        // Introduce the game to the user
        System.out.println("Hello, this is an adventure game. You will asscend a tower to gear up and fight monsters.\nYou gear up for 4 floors, gaining health and weapons, but every fifth floor, you will\nencounter a monster. This game will repeat until you die, so good luck. By the way,\nthe items and mosnters will have increased stats depending on the floor. Ad Astra Abyssoque.");

        Generic.printArrayList(plrList);

        // Initializes the player
        System.out.println ("\nEvery champion fits a category.");
        plrUser = plrList.get(Generic.getByte((byte)1, "What class of player do you want to be: ", (byte)1, (byte)plrList.size())-1);

        // Ask the user for a name
        System.out.println ("\nOk, now, let's get you a name fit for a legend.");
        plrUser.setPName(Generic.getString((byte)0, "What is your " + plrUser.getPName() + "'s  name: ", "",""));
        System.out.print ("\n" + plrUser.getPName() + ", what a strapping name. Now let us enter the first floor of the Tower.");

        GameLoop.StartGame();
    } // End of main

    /*
      Description: This method just asks the user whether they want to continue playing after defeating an enemy
      @Author: Hovan Lee
      @Date: June 15, 2021
    */
    public static void playerWin(){
        // Get the user's response as to whether they want to continue
        String strContinue = Generic.getString((byte)1, "Do you want to continue climbing the Tower, yes or no: ", "yes","no");

        // Checks if the user said yes they want to continue
        if (strContinue.equalsIgnoreCase("yes"))
        {
            bolIsGameOver = false;
        } // End of continuing the game
        // The user wants to leave
        else
        {
            bolIsGameOver = true;
        } // End of leaving the tower
    } // End of PlayerWin

    /*
      Description: This method prints out the score(number of floors conquered) with the users name, health, and held weapon to a file. This adds to the file so the user can see previous scores.
      @Author: Shirley Nguyen
      @Date: June 15, 2021
    */
    public static void printScore()
    {
        //outputting the score for the user to see
        System.out.println("\nYou have exited the Tower.\n" + plrUser.getPName() + " was last seen on floor " + lvlBuilder.getNumberOfBlocks() + " holding a " + plrUser.getPWeapon().getWeaponName()+".");

        //storing the score in a file for all games
        try
        {
            //creating the file
            FileWriter writer = new FileWriter("Score.txt", true);

            //writing to the file
            writer.write(plrUser.getPName() + " was last seen on floor " + lvlBuilder.getNumberOfBlocks() + " holding the " + plrUser.getPWeapon().getWeaponName() + ".\n");

            //closing the file
            writer.close();

            //outputting that the score was printed to a file
            System.out.println("Your score has been stored in the Score file for future reference.");
        }
        catch(FileNotFoundException e)
        {
            //outputting error message
            System.out.println("Error. Cannot find file.");
        }
        catch(IOException e)
        {
            //outputting error message
            System.out.println("An error has occured, the score could not be stored in the file.");
        }
    }

    /*
      Description: This method populates the ArrayList with weapons
      @Author: Hovan Lee
      @Date: June 14, 2021
    */
    private static void initiliazeWeapons()
    {
        // Stores the list of possible weapons
        wpnList.add(new Weapon ("Dessert Eagle", 15.3f, (byte)85, (byte)2));
        wpnList.add(new Weapon ("Machete", 10.1f, (byte)95, (byte)1));
        wpnList.add(new Weapon ("Nunchucks", 8f, (byte)78, (byte)3));
        wpnList.add(new Weapon ("Taser", 43.7f, (byte)69, (byte)1));
        wpnList.add(new Weapon ("Holy Hand Grenade", 1000f, (byte)2, (byte)1));
        wpnList.add(new Weapon ("Ak-47", 26.7f, (byte)35, (byte)7));
        wpnList.add(new Weapon ("AC Unit", 59.4f, (byte)50, (byte)1));
        wpnList.add(new Weapon ("Frying Pan", 8.3f, (byte)100, (byte)5));
        wpnList.add(new Weapon ("Banana", 60f, (byte)15, (byte)15));
    } // End of InitiliazeWeapons

    /*
      Description: This method populates the ArrayList with enemies
      @Author: Shirley Nguyen & Hovan Lee
      @Date: June 15, 2021
    */
    private static void initializeEnemies()
    {
        // Stores the list of possible enemies
        enmList.add(new Enemy ("Jeff", 100.01f, wpnList.get(8), (byte)5));
        enmList.add(new Enemy ("Richard", 95.3f, wpnList.get(3),(byte)6));
        enmList.add(new Enemy ("Geesus", 207.89f, wpnList.get(4),(byte)8));
        enmList.add(new Enemy ("Elmo", 78f, wpnList.get(7),(byte)10));
        enmList.add(new Enemy ("Barney", 83.42f, wpnList.get(2), (byte)1));
        enmList.add(new Enemy ("Teletubby", 73.98f, wpnList.get(0), (byte)6));
        enmList.add(new Enemy ("Fix-it Felix", 71.39f, wpnList.get(6),(byte)4));
        enmList.add(new Enemy ("Pablo", 82.12f, wpnList.get(5), (byte)3));
        enmList.add(new Enemy ("Navoh", 96.95f, wpnList.get(1),(byte)5));
    } // End of InitializeEnemies

    /*
     * Description: Populates the options for player classes
     *
     * @author (Shirley Nguyen)
     * @version (June 16, 2021)
     */
    private static void initializePlayer()
    {
        //populating the ArrayList
        plrList.add(new Player ("Swordsman", 175, new Weapon ("Baby's First Sword", 20.8f, (byte)78, (byte)2), (byte)6, (byte)3));
        plrList.add(new Player ("Defender", 300, new Weapon ("Baby's First Shield", 26.45f, (byte)96, (byte)1), (byte)2, (byte)2));
        plrList.add(new Player ("Sniper", 130, new Weapon ("Baby's First M25", 30.9f, (byte)100, (byte)1), (byte)3, (byte)2));
        plrList.add(new Player ("Rogue", 100, new Weapon ("Baby's First Knife", 7.2f, (byte)68, (byte)7), (byte)8, (byte)4));
        plrList.add(new Player ("Arsonist", 150, new Weapon ("Baby's First Matches", 4f, (byte)90, (byte)10), (byte)7, (byte)3));
    }
} // End of Main