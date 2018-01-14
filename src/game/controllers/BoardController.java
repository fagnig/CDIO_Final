package game.controllers;

import java.awt.Color;

import game.model.fields.*;
import game.model.fields.notownable.*;
import game.model.fields.ownable.*;
import game.model.Language;
import game.model.Player;

/**
 * Takes care of all functions related to the board.
 * Builds all the fields and gives access to the fields.
 */
public class BoardController {
    private Field[] fields  = new Field[40];
    
    public BoardController(){
    	init();
    }

    /**
     * Initialises every field.
     * All values for the fields are listed here.
     */
    private void init(){
    	int[] rent = {1,2,3,4,5};
    	int[] shippingrent = {500,1000,2000,4000};
    	int[] rent1 = {50,250,750,2250,4000,6000};
    	int[] rent2 = {100,600,1800,5400,9000,11000};
    	int[] best2 = {150,800,2000,6000,9000,12000};
    	int[] rent3 = {200,1000,3000,9000,12500,15000};
    	int[] best3 = {250,1250,3750,10000,14000,18000};
    	int[] rent4 = {300,1400,4000,11000,15000,19000};
    	int[] best4 = {350,1600,4400,12000,16000,20000};
    	int[] rent5 = {350,1800,5000,14000,17500,21000};
    	int[] best5 = {400,2000,6000,15000,18500,22000};
    	int[] rent6 = {450,2200,6600,16000,19500,23000};
    	int[] best6 = {500,2400,7200,17000,20500,24000};
    	int[] rent7 = {550,2600,7800,18000,22000,25000};
    	int[] best7 = {600,3000,9000,20000,24000,28000};
    	int[] rent8 = {700,3500,10000,22000,26000,30000};
    	int[] best8 = {1000,4000,12000,28000,34000,40000};

    	String[] fieldNames = Language.fieldNames();

        fields[0] = new StartField(fieldNames[0], Color.RED,Color.BLACK);
        fields[1] = new BuildableField(fieldNames[1], Color.cyan, Color.black, 1,rent1, 1200, 1000) ;
        fields[2] = new ChanceField(fieldNames[2],Color.black, Color.green);
        fields[3] = new BuildableField(fieldNames[3], Color.cyan, Color.black, 1,rent1, 1200, 1000);
        fields[4] = new TaxField(fieldNames[4], Color.WHITE, Color.BLACK);
        fields[5] = new ShippingField(fieldNames[5], Color.blue, Color.black, 0,shippingrent, 4000);
        fields[6] = new BuildableField(fieldNames[6], Color.orange, Color.black, 2,rent2, 2000, 1000);
        fields[7] = new ChanceField(fieldNames[7],Color.black, Color.green);
        fields[8] = new BuildableField(fieldNames[8], Color.orange, Color.black, 2, rent2, 2000, 1000);
        fields[9] = new BuildableField(fieldNames[9], Color.orange, Color.black, 2,best2, 2400, 1000);
        fields[10] = new PrisonField(fieldNames[10], Color.black, Color.white);
        fields[11] = new BuildableField(fieldNames[11], Color.green, Color.black, 3,rent3, 2800, 2000);
        fields[12] = new BreweryField(fieldNames[12], Color.red, Color.black, 9,rent, 3000);
        fields[13] = new BuildableField(fieldNames[13], Color.green, Color.black, 3,rent3, 2800, 2000);
        fields[14] = new BuildableField(fieldNames[14], Color.green, Color.black, 3,best3, 3200, 2000);
        fields[15] = new ShippingField(fieldNames[15], Color.RED, Color.black, 0,shippingrent, 4000);
        fields[16] = new BuildableField(fieldNames[16], Color.gray, Color.black, 4,rent4, 3600, 2000);
        fields[17] = new ChanceField(fieldNames[17], Color.black, Color.green);
        fields[18] = new BuildableField(fieldNames[18], Color.gray, Color.black, 4,rent4, 3600, 2000);
        fields[19] = new BuildableField(fieldNames[19], Color.gray, Color.black, 4,best4, 4000, 2000);
        fields[20] = new RefugeField(fieldNames[20], Color.black, Color.white);
        fields[21] = new BuildableField(fieldNames[21], Color.red, Color.black, 5,rent5, 4400, 3000);
        fields[22] = new ChanceField(fieldNames[22], Color.black, Color.green);
        fields[23] = new BuildableField(fieldNames[23], Color.red, Color.black, 5,rent5, 4400, 3000);
        fields[24] = new BuildableField(fieldNames[24], Color.RED, Color.black, 5,best5, 4800, 3000);
        fields[25] = new ShippingField(fieldNames[25], Color.BLUE, Color.black, 0,shippingrent, 4000);
        fields[26] = new BuildableField(fieldNames[26], Color.WHITE, Color.black, 6,rent6, 5200, 3000);
        fields[27] = new BuildableField(fieldNames[27], Color.WHITE, Color.black, 6,rent6, 5200, 3000);
        fields[28] = new BreweryField(fieldNames[28], Color.RED, Color.black, 9,rent, 3000);
        fields[29] = new BuildableField(fieldNames[29], Color.WHITE, Color.black, 6,best6, 5600, 3000);
        fields[30] = new PrisonField(fieldNames[30], Color.black, Color.white);
        fields[31] = new BuildableField(fieldNames[31], Color.YELLOW, Color.black, 7,rent7, 6000, 4000);
        fields[32] = new BuildableField(fieldNames[32], Color.YELLOW, Color.black, 7,rent7, 6000, 4000);
        fields[33] = new ChanceField(fieldNames[33], Color.BLACK, Color.green);
        fields[34] = new BuildableField(fieldNames[34], Color.YELLOW, Color.black, 7,best7, 6000, 4000);
        fields[35] = new ShippingField(fieldNames[35], Color.BLUE, Color.black, 0,shippingrent, 4000);
        fields[36] = new ChanceField(fieldNames[36], Color.BLACK, Color.green);
        fields[37] = new BuildableField(fieldNames[37], Color.decode("#551A8B"), Color.black, 8,rent8, 7000, 4000);
        fields[38] = new TaxField(fieldNames[38], Color.white, Color.black);
        fields[39] = new BuildableField(fieldNames[39], Color.decode("#551A8B"), Color.black, 8,best8, 8000, 4000);
    }

    public Field[] getFields() {
        return fields;
    }

    /**
     * Gets a specific field in the array
     * @param loc the index of the field
     * @return the field at the given index
     */
    public Field getField(int loc){
    	return fields[loc];
    }


    /**
     * Sets how many of a field are owned, and checks if a player can build.
     * @param allPlayers Every player in the game
     */
    public void setAllVals(Player[] allPlayers){
        for (Player allPlayer : allPlayers) {
            for (int j = 1; j < 10; j++) {
                if (areAllOwned(allPlayer, j)) {
                    for (Field field : fields) {
                        if (field instanceof BuildableField || field instanceof BreweryField) {
                            OwnableField curField = ((OwnableField) field);
                            if (curField.getGroup() == j) {
                                curField.setAmountOwned(2);
                            }
                            if(field instanceof BuildableField){
                                canBuild((BuildableField) field);
                            }
                        }
                    }
                }
            }
            for (Field field : fields) {
                if (field instanceof ShippingField) {
                    OwnableField curField = ((OwnableField) field);
                    if (curField.getOwner() != null && curField.getOwner().equals(allPlayer)) {
                        curField.setAmountOwned(shippingOwned(allPlayer));
                    }
                }
            }

        }
    }

    /**
     * Checks if all fields of a certain group are owned by one player.
     * @param curPlayer the player we are checking for.
     * @param groupID the colour code of the fields we are checking for.
     * @return if all fields in the group are owned by the specified player.
     */
    private boolean areAllOwned(Player curPlayer, int groupID){
        for (Field field : fields) {
            if (field instanceof BuildableField || field instanceof BreweryField) {
                OwnableField curField = ((OwnableField) field);
                if (curField.getGroup() == groupID) {
                    if (curField.getOwner() == null) {
                        return false;
                    }
                    if (!curField.getOwner().equals(curPlayer)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Checks if all fields of the same group are buildable
     * @param field the field to test
     */
    private void canBuild(BuildableField field){
        int max = 0, min = 0;
        int groupID = field.getGroup();


        for(int i=0; i<40; i++){
            if (field.getGroup() == groupID) {
                min = field.getBuildStatus();
                if(min > max) {
                    max = min;
                }
            }
        }
        if(field.getBuildStatus() == min){
            field.setBuildable(true);
        } else {
            field.setBuildable(false);
        }
        if (field.getBuildStatus() == 5){
            field.setBuildable(false);
        }
    }



    /**
     * Checks how many shippingfields are owned by the specified player.
     * @param curPlayer the player we are checking for.
     * @return amount of shippingfields owned by the specified player.
     */
    private int shippingOwned(Player curPlayer){
        int tempVal = 1;
        for(int i=0; i<=3; i++){
            if (((OwnableField)fields[5 + i*10]).getOwner() != null){
                if (((OwnableField) fields[5 + i * 10]).getOwner().equals(curPlayer)) {
                    tempVal++;
                }
            }
        }
        return tempVal;
    }
}
