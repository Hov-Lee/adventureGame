package com.company;

/**
 * Description: This class constructs a block of the tower, either giving two items
 * or telling the program that it's an enemy block
 * @author (Majed Madamani) & (Shirley Nguyen) & (Hovan Lee)
 * @Date (June 14, 2021)
 **/

// Import Java classes
import java.lang.Math;
import java.util.ArrayList;

public class Block {
    private byte bytLeftItem; //-1 or the index of weapon from the weapons list
    private byte bytRightItem; //-1 or the index of weapon from the weapons list
    private boolean bolEnemyBlock;
    private byte bytBlockIndex;

    //creating the arraylists to hold the phrases for weapons and health
    private static ArrayList <String> hpPhraseList = new ArrayList <String>();
    private static ArrayList <String> wpnPhraseList = new ArrayList <String>();

    /**
     * Description: This method will decide whether this block contains an enemy or items,
     * if items it will contruct a block that contains two items as well as a hint to the
     * player as to what is on each path
     * @author (Majed Madamani) & (Hovan Lee) - Adding the phrases.
     * @Date (June 14, 2021)
     **/
    public Block(byte lengthOfWeaponsList, byte bytBlockIndex){
        System.out.print("\n\nFloor " + bytBlockIndex);
        if(bytBlockIndex % 5 == 0){
            this.bolEnemyBlock = true;
        }else{
            this.bolEnemyBlock = false;
            if ((byte)Math.floor(Math.random()*2) == 0){
                this.bytLeftItem = -1;
                System.out.print("\nThe left path " + Block.hpPhraseList.get((byte)Math.floor(Math.random() * Block.hpPhraseList.size())) + " and ");
            }else{
                this.bytLeftItem = (byte)Math.floor(Math.random() * lengthOfWeaponsList);
                System.out.print("\nThe left path " + Block.wpnPhraseList.get((byte)Math.floor(Math.random() * Block.wpnPhraseList.size())) + " and ");
            }
            if (bytLeftItem == -1){
                this.bytRightItem = (byte)Math.floor(Math.random() * lengthOfWeaponsList);
                System.out.println("the right path " + Block.wpnPhraseList.get((byte)Math.floor(Math.random() * Block.wpnPhraseList.size())) + ".");
            }else{
                this.bytRightItem = -1;
                System.out.println("the right path " + Block.hpPhraseList.get((byte)Math.floor(Math.random() * Block.hpPhraseList.size())) + ".");
            }
        }
    }


    /**
     * Description: Getter and setter methods
     * @author (Majed Madamani)
     * @Date (June 14, 2021)
     **/
    public byte getBytLeftItem() {
        return bytLeftItem;
    }
    public boolean getBolEnemyBlock () {return bolEnemyBlock;}
    public byte getBytRightItem() {
        return bytRightItem;
    }
    public short getBytBlockIndex() {
        return bytBlockIndex;
    }

    public void setBytRightItem(byte bytRightItem) {
        this.bytRightItem = bytRightItem;
    }
    public void setBytLeftItem(byte bytLeftItem) {
        this.bytLeftItem = bytLeftItem;
    }
    
    /**
     * Description: Populates and arraylist to hold the phrases for health.
     * @author (Shirley Nguyen)
     * @Date (June 16, 2021)
     **/
    public static void hpInitializePhrases()
    {
        //populating the list with phrases
        Block.hpPhraseList.add("looks ominously red");
        Block.hpPhraseList.add("fills you with determination");
        Block.hpPhraseList.add("radiates an unknown warmth");
        Block.hpPhraseList.add("makes you question why you entered the Tower");
        Block.hpPhraseList.add("pulls you towards it, literally");
        Block.hpPhraseList.add("feels strangely nostalgic");
        Block.hpPhraseList.add("echoes with the sounds of cat videos");
        Block.hpPhraseList.add("is a candle lit steak dinner");
        Block.hpPhraseList.add("looks like a marvelous time");
    }

    public void setBytBlockIndex(byte bytBlockIndex) {
        this.bytBlockIndex = bytBlockIndex;
    }
    /**
     * Description: Populates an arraylist to hold the phrases for weapons.
     * @author (Hovan Lee)
     * @Date (June 16, 2021)
     **/
    public static void wpnInitializePhrases()
    {
        //populating the list with phrases
        Block.wpnPhraseList.add("glistens with the light of power");
        Block.wpnPhraseList.add("draws your monkey brain");
        Block.wpnPhraseList.add("feeds off anger as your grip tightens");
        Block.wpnPhraseList.add("SCREAMS out to you");
        Block.wpnPhraseList.add("makes you laugh giddily");
        Block.wpnPhraseList.add("reminds you of getting cut in traffic");
        Block.wpnPhraseList.add("is pretty cool");
        Block.wpnPhraseList.add("... hehehe...");
        Block.wpnPhraseList.add("is strong");
    } // End of wpnPhrases
}
