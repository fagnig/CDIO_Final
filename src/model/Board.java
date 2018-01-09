package model;

import java.awt.Color;

import fields.*;


public class Board {
	private static Board board = new Board();
    private Field[] fields  = new Field[40];
    
    private Board(){
    	init();
    }
    
    public static Board getInstance() {
    	return board;
    }
    
    public void init(){
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
    	
        fields[0] = new StartField("Start", Color.RED,Color.BLACK);
        fields[1] = new BuildableField("Rødovrevej", Color.cyan, Color.black, 1,rent1, 1200, 1000) ;
        fields[2] = new ChanceField("Chance",Color.black, Color.green);
        fields[3] = new BuildableField("Hvidovrevej", Color.cyan, Color.black, 1,rent1, 1200, 1000);
        fields[4] = new IncomeTaxField("Indkomstskat", Color.WHITE, Color.BLACK);
        fields[5] = new ShippingField("Redderiget Lindinger A/S", Color.blue, Color.black, 2,shippingrent, 4000);
        fields[6] = new BuildableField("RoskildeVej", Color.orange, Color.black, 1,rent2, 2000, 1000);
        fields[7] = new ChanceField("Chance",Color.black, Color.green);
        fields[8] = new BuildableField("Valby Langgade", Color.orange, Color.black, 3, rent2, 2000, 1000);
        fields[9] = new BuildableField("Allégade", Color.orange, Color.black, 3,best2, 2400, 1000);
        fields[10] = new RefugeField("På besøg", Color.black, Color.white);
        fields[11] = new BuildableField("Frederiksberg Allé", Color.green, Color.black, 3,rent3, 2800, 2000);
        fields[12] = new BreweryField("Tuborg", Color.red, Color.black, 3,rent, 3000);
        fields[13] = new BuildableField("Bülowsvej", Color.green, Color.black, 3,rent3, 2800, 2000);
        fields[14] = new BuildableField("Gl. Kongevej", Color.green, Color.black, 3,best3, 3200, 2000);
        fields[15] = new ShippingField("Mols - Linien", Color.RED, Color.black, 4,shippingrent, 4000);
        fields[16] = new BuildableField("Bernstorffsvej", Color.gray, Color.black, 3,rent4, 3600, 2000);
        fields[17] = new ChanceField("Chance", Color.black, Color.green);
        fields[18] = new BuildableField("Hellerupvej", Color.gray, Color.black, 3,rent4, 3600, 2000);
        fields[19] = new BuildableField("Strandvejen", Color.gray, Color.black, 3,best4, 4000, 2000);
        fields[20] = new RefugeField("Parkering", Color.black, Color.white);
        fields[21] = new BuildableField("Trianglen", Color.red, Color.black, 3,rent5, 4400, 3000);
        fields[22] = new ChanceField("Chance", Color.black, Color.green);
        fields[23] = new BuildableField("Østerbrogade", Color.red, Color.black, 3,rent5, 4400, 3000);
        fields[24] = new BuildableField("Grønningen", Color.RED, Color.black, 3,best5, 4800, 3000);
        fields[25] = new ShippingField("Gedser-Rostock", Color.BLUE, Color.black, 4,shippingrent, 4000);
        fields[26] = new BuildableField("Bredgade", Color.WHITE, Color.black, 3,rent6, 5200, 3000);
        fields[27] = new BuildableField("Kgs Nytorv", Color.WHITE, Color.black, 3,rent6, 5200, 3000);
        fields[28] = new BreweryField("Carlsberg", Color.RED, Color.black, 3,rent, 3000);
        fields[29] = new BuildableField("Østergade", Color.WHITE, Color.black, 3,best6, 5600, 3000);
        fields[30] = new PrisonField("De fængsles", Color.black, Color.white);
        fields[31] = new BuildableField("Amagertorv", Color.YELLOW, Color.black, 3,rent7, 6000, 4000);
        fields[32] = new BuildableField("Vimmelskaftet", Color.YELLOW, Color.black, 3,rent7, 6000, 4000);
        fields[33] = new ChanceField("Chance", Color.BLACK, Color.green);
        fields[34] = new BuildableField("Nygade", Color.YELLOW, Color.black, 3,best7, 6000, 4000);
        fields[35] = new ShippingField("Rødby-Puttgarden", Color.BLUE, Color.black, 3,shippingrent, 4000);
        fields[36] = new ChanceField("Chance", Color.BLACK, Color.green);
        fields[37] = new BuildableField("Frederiksberggade", Color.PINK, Color.black, 3,rent8, 7000, 4000);
        fields[38] = new GovTaxField("Statsskat", Color.white, Color.black);
        fields[39] = new BuildableField("Rådhuspladsen", Color.PINK, Color.black, 3,best8, 8000, 4000); 
    }

    public Field[] getFields() {
        return fields;
    }
}
