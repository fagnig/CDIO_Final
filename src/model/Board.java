package model;

import java.awt.Color;

import fields.*;


public class Board {

    private Field[] fields  = new Field[40];
    
    public Board(){
    	init();
    }
    public void init(){
    	int[] rent = {200,500,1000,2000,4000};
        fields[0] = new StartField("Start", Color.RED,Color.BLACK);
        fields[1] = new BuildableField("Rødovrevej", Color.blue, Color.black, 1,rent, 1200, 1000);
        fields[2] = new ChanceField("Chance",Color.black, Color.green);
        fields[3] = new BuildableField("Hvidovrevej", Color.blue, Color.black, 1,rent, 1200, 1000);
        fields[4] = new IncomeTaxField("betal skat pikhoved", Color.WHITE, Color.BLACK);
        fields[5] = new ShippingField("Redderiget Lindinger A/S", Color.blue, Color.black, 2,rent, 4000);
        fields[6] = new BuildableField("RoskildeVej", Color.orange, Color.black, 1,rent, 2000, 1000);
        fields[7] = new ChanceField("Prøv Lykken",Color.green, Color.black);
        fields[8] = new BuildableField("Valby Langgade", Color.orange, Color.black, 3, rent, 2000, 1000);
        fields[9] = new BuildableField("Allégade", Color.orange, Color.black, 3,rent, 2400, 1000);
        fields[10] = new RefugeField("På besøg", Color.black, Color.white);
        fields[11] = new BuildableField("Frederiksberg Allé", Color.green, Color.black, 3,rent, 2800, 1000);
        fields[12] = new BreweryField("Squash", Color.red, Color.black, 3,rent, 3000);
        fields[13] = new BuildableField("Bülowsvej", Color.green, Color.black, 3,rent, 2800, 1000);
        fields[14] = new BuildableField("Gl. Kongevej", Color.green, Color.black, 3,rent, 3200, 1000);
        fields[15] = new ShippingField("Mols - Linien", Color.RED, Color.black, 4,rent, 4000);
        fields[16] = new BuildableField("Bernstorffsvej", Color.gray, Color.black, 3,rent, 3600, 1000);
        fields[17] = new ChanceField("Prøv Lykken", Color.black, Color.green);
        fields[18] = new BuildableField("Hellerupvej", Color.gray, Color.black, 3,rent, 3600, 1000);
        fields[19] = new BuildableField("Strandvejen", Color.gray, Color.black, 3,rent, 4000, 1000);
        fields[20] = new RefugeField("Parkering", Color.blue, Color.black);
        fields[21] = new BuildableField("Trianglen", Color.red, Color.black, 3,rent, 4400, 1000);
        fields[22] = new ChanceField("Prøv Lykken", Color.black, Color.green);
        fields[23] = new BuildableField("Østerbrogade", Color.red, Color.black, 3,rent, 4400, 1000);
        fields[24] = new BuildableField("Valby Langgad123e", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[25] = new BuildableField("Valby Lan3ggade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[26] = new BuildableField("Valby Lang21gade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[27] = new BuildableField("Valby Lang432423gade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[28] = new BuildableField("Valby Lang12e", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[29] = new BuildableField("Valby La222nggade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[30] = new BuildableField("Valby Lan123ggade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[31] = new BuildableField("Valby Lan543ggade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[32] = new BuildableField("Valby Langgade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[33] = new BuildableField("Valby La312nggade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[34] = new BuildableField("Valby Lan11ggade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[35] = new BuildableField("Valby Lan234ggade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[36] = new BuildableField("Valby Lan22ggade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[37] = new BuildableField("Valby Langg33ade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[38] = new BuildableField("Valby Lang33g1111ade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[39] = new BuildableField("Valby Lan11ggade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
       

    }

    public Field[] getFields() {
        return fields;
    }
}
