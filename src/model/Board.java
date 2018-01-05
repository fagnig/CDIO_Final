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
        fields[1] = new BuildableField("Rødovrevej", Color.YELLOW, Color.black, 1,rent, 1200, 1000);
        fields[2] = new ChanceField("Chance",Color.YELLOW, Color.black);
        fields[3] = new BuildableField("Hvidovrevej", Color.YELLOW, Color.black, 1,rent, 1200, 1000);
        fields[4] = new IncomeTaxField("betal skat pikhoved", Color.WHITE, Color.BLACK);
        fields[5] = new ShippingField("Redderiget Lindinger A/S", Color.YELLOW, Color.black, 2,rent, 1200);
        fields[6] = new BuildableField("RoskildeVej", Color.YELLOW, Color.black, 1,rent, 1200, 1000);
        fields[7] = new ChanceField("Chance",Color.YELLOW, Color.black);
        fields[8] = new BuildableField("Valby Langgade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[9] = new BuildableField("Valby Langgade", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[10] = new BuildableField("Valby Langgade1", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[11] = new BuildableField("Valby Langgade2", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[12] = new BuildableField("Valby Langgade3", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[13] = new BuildableField("Valby Langgade4", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[14] = new BuildableField("Valby Langgade5", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[15] = new BuildableField("Valby Langgade6", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[16] = new BuildableField("Valby Langgade7", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[17] = new BuildableField("Valby Langgade8", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[18] = new BuildableField("Valby Langgade9", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[19] = new BuildableField("Valby Langgade22", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[20] = new BuildableField("Valby Langgade11", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[21] = new BuildableField("Valby Langgade312", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[22] = new BuildableField("Valby Langgade5", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
        fields[23] = new BuildableField("Valby Langgade32423", Color.YELLOW, Color.black, 3,rent, 1200, 1000);
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
