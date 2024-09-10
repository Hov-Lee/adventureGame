package com.company;

/*
  Description: This class plays the main game of rising through the tower
  @Author: Majed
  @Date: June 15, 2021
*/
public class GameLoop{
    /*
     Description: This method starts a floor of the tower
     @Author: Majed
     @Date: June 15, 2021
   */

    public static void StartGame(){
        Main.lvlBuilder = new LevelBuilder((byte)Main.wpnList.size());
        PlayGame();
    }

    /*
      Description: This method allows the player to interact with a floor
      @Author: Majed
      @Date: June 15, 2021
    */
    private static void PlayGame(){
        boolean bolIsEnemyBlock = false;
        Weapon wpnFloorWeapon;

        byte bytItemType = Main.lvlBuilder.getBlockItem(Generic.getString((byte)1, "Would you like to go left, or right: ", "left","right"));

        if(bytItemType == -1){
            Main.plrUser.giveHealthItem();
        }else{
            Main.plrUser.addWeapon(Main.wpnList.get(bytItemType));
        }

        while(!Main.bolIsGameOver){
            Main.lvlBuilder.MoveToNextBlock();
            bolIsEnemyBlock = Main.lvlBuilder.getCurrentBlock().getBolEnemyBlock();
            if(bolIsEnemyBlock){
                StartBattleWithEnemy();
            }else{
                bytItemType = Main.lvlBuilder.getBlockItem(Generic.getString((byte)1, "Would you like to go left, or right: ", "left","right"));
                if(bytItemType == -1){
                    Main.plrUser.giveHealthItem();
                }else{
                    wpnFloorWeapon = new Weapon(Main.wpnList.get(bytItemType).getWeaponName(), Main.wpnList.get(bytItemType).getAmountOfDamage(), Main.wpnList.get(bytItemType).getAccuracy(), Main.wpnList.get(bytItemType).getNumHits());
                    Main.plrUser.addWeapon(wpnFloorWeapon);
                }
            }
        }
        //outputting the score by calling the score method
        Main.printScore();
    }

    /*
      Description: This method plays out the battle sequence once a monster has been encountered
      @Author: Majed & Hovan
      @Date: June 15, 2021
    */
    public static void StartBattleWithEnemy(){
        // Stores a random number to become
        byte bytRandom = (byte)Math.floor(Math.random()*Main.enmList.size());
        // Stores who's turn it is and selects someone to go first based on speed
        byte bytTurn;
        // Stores whether the battle is over
        boolean bolIsBattleOver = false;
        // Make a copy of the random enemy's weapon that will then be modified later
        Weapon weaponInstance = Main.enmList.get(bytRandom).getEWeapon();
        Weapon wpnEnemyWeapon = new Weapon(weaponInstance.getWeaponName(), weaponInstance.getAmountOfDamage(), weaponInstance.getAccuracy(), weaponInstance.getNumHits());
        // Copy over the profile of the random enemy from the list and modify it
        Enemy blockEnemy = new Enemy(Main.enmList.get(bytRandom).getEName(), Main.enmList.get(bytRandom).getEHealth(), wpnEnemyWeapon, Main.enmList.get(bytRandom).getESpeed());
        blockEnemy.modifyEnemy();

        // Checks if the enemy is faster
        if (Main.plrUser.getPSpeed() < blockEnemy.getESpeed())
        {
            bytTurn = (byte)0;
        } // end of the user being faster
        // The user is first
        else
        {
            bytTurn = (byte)1;
        } // End of the user being faster

        // Prints out the weapons for the user to choose which to fight with
        Generic.printArrayList(Main.plrUser.getPWeaponList());
        System.out.println();

        // Ask which weapon the user would like to fight with and set it as the held weapon
        Main.plrUser.setPWeapon(Main.plrUser.getPWeaponList().get(Generic.getByte((byte)1,"You are about to fight to the death, with " + Main.plrUser.getPHealth() + " health.\nWhich weapon do you want to fight with: ", (byte)1,(byte)Main.plrUser.getPWeaponList().size())-1));

        // Tell the user the name of their opponent
        System.out.println("You will be fighting " + blockEnemy.getEName() + ", who has " + blockEnemy.getEHealth() + " health. Good luck, you might need it.\n");

        // Repeat hits back and forth until someone dies
        while(!bolIsBattleOver){
            // Checks if it is the enemy's turn
            if(bytTurn == 0){
                // Hit the enemy the number of shots the weapon has or until the enemy is dead
                for(int i = 0; i < blockEnemy.getEWeapon().getNumHits() && Main.plrUser.getPHealth() > 0; i++){
                    // Checks if the user's attack hit
                    if (blockEnemy.getEWeapon().hit())
                    {
                        // Subtract the user's weapon's attack from the health of the enemy and tell the user
                        Main.plrUser.takeDamage(blockEnemy.getEWeapon().getAmountOfDamage());
                        System.out.println (blockEnemy.getEName() + " dealt " + blockEnemy.getEWeapon().getAmountOfDamage() + " damage to " + Main.plrUser.getPName() + " with the " + blockEnemy.getEWeapon().getWeaponName() + ", bringing your health to " + Main.plrUser.getPHealth());
                    } // End of a hit
                    // The user missed the enemy
                    else
                    {
                        // Tell the user they missed
                        System.out.println (blockEnemy.getEName() + " tried to hit " + Main.plrUser.getPName() + ", but missed");
                    } // End of the user missing
                } // End of hitting the enemy


                // Set it so that it is now the enemy's turn to attack
                bytTurn = (byte)1;

                // Check if the user's health is zero or less, if yes shut down the game
                if(Main.plrUser.getPHealth() <= 0){
                    // Record that the battle is over
                    bolIsBattleOver = true;

                    // Record that the game is over
                    Main.bolIsGameOver = true;

                    // Notify the user of the death
                    System.out.println("\nSometimes people get unlucky, but nevertheless, you died at the hands of " + blockEnemy.getEName()+".");
                } // End of the user dying
                // The user is attacking
            }else{
                // Hit the user the number of shots the weapon has or until the user is dead
                for(int i = 0; i < Main.plrUser.getPWeapon().getNumHits() && blockEnemy.getEHealth() > 0; i++){
                    // Check if the enemy's weapon hit
                    if (Main.plrUser.getPWeapon().hit())
                    {
                        // Subtract the enemy's damage from the user's health and tell the user
                        blockEnemy.takeDamage(Main.plrUser.getPWeapon().getAmountOfDamage());
                        System.out.println (Main.plrUser.getPName() + " dealt " + Main.plrUser.getPWeapon().getAmountOfDamage() + " damage to " + blockEnemy.getEName() + " with the " + Main.plrUser.getPWeapon().getWeaponName() + ", bringing its health to " + blockEnemy.getEHealth());
                    } // End of an enemy's hit
                    // The enemy's weapon missed
                    else
                    {
                        // Tell the user that the enemy missed
                        System.out.println (Main.plrUser.getPName() + " tried to hit " + blockEnemy.getEName() + ", but missed");
                    } // End of the enemy missing
                } // End of hitting the user

                // Set it so that it is now the user's turn
                bytTurn = (byte)0;

                // Check if the enemy is dead
                if(blockEnemy.getEHealth() <= 0){
                    // Record that the battle is over
                    bolIsBattleOver = true;

                    // Tell the user that they have won
                    System.out.println("\nYou killed " + blockEnemy.getEName() + ", they died. You won the battle.");

                    // Initiate the playerWin method
                    Main.playerWin();
                } // End of the enemy dying
            } // End of the enemy's turn
        } // End of the battle
    } // End of StartBattleWithEnemy
} // End of GameLoop