package com.company;

/**
 * Description: This class is responsible for buiding a block and moving the player up the tower by
 * re-intializing the current block.
 * @author (Majed Madamani)
 * @Date (June 17, 2021)
 **/
public class LevelBuilder {
    private byte bytNumberOfBlock = 1; // current number of completed blocks
    private final byte bytlengthWeaponsList; // Size of the weapon arrayList
    private Block currentBlock; // Contains the current block the player is currently at right now.

    /**
     * Description: This constructor intiliazes the size of the weapon list and also creates the first block.
     * re-intializing the current block.
     * @author (Majed Madamani)
     * @Date (June 17, 2021)
     **/
    public LevelBuilder(byte bytlengthWeaponsList){
        this.bytlengthWeaponsList = bytlengthWeaponsList;
        this.currentBlock = new Block(this.bytlengthWeaponsList, this.bytNumberOfBlock);
    }
    /**
     * Description: This function returns a byte based on the direction that the player chose to go in
     * (left: 0 or right: 1), the number that would be returned would either be, -1 for health item, or
     * the weapon index from the weapon array list.
     * @author (Majed Madamani)
     * @Date (June 17, 2021)
     **/
    public byte getBlockItem(String direction){ //0 for left item, 1 for right item
        return direction.equalsIgnoreCase("left") ? currentBlock.getBytLeftItem() : currentBlock.getBytRightItem();
    }

    /**
     * Description: This function is called when the player moves to the next block, either when they make
     * a choice for going left or right, or when they defeat the enemy. And basically it makes a new block
     * and increases the number of completed blocks.
     * @author (Majed Madamani)
     * @Date (June 17, 2021)
     **/
    public void MoveToNextBlock(){
        this.bytNumberOfBlock++;
        currentBlock = new Block(this.bytlengthWeaponsList, this.bytNumberOfBlock);
    }
    /**
     * Description: Getters.
     * @author (Majed Madamani)
     * @Date (June 17, 2021)
     **/
    public byte getNumberOfBlocks(){
        return this.bytNumberOfBlock;
    }
    public Block getCurrentBlock(){ return this.currentBlock; }
}