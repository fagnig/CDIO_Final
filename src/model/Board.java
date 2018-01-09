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
    	int[] rent = {200,500,1000,2000,4000,5000};
        fields[0] = new StartField("Start", Color.RED,Color.BLACK);
        fields[1] = new BuildableField("Rødovrevej", Color.blue, Color.black, 1,rent, 1200, 1000);
        fields[2] = new ChanceField("Chance",Color.black, Color.green);
        fields[3] = new BuildableField("Hvidovrevej", Color.blue, Color.black, 1,rent, 1200, 1000);
        fields[4] = new IncomeTaxField("Indkomstskat", Color.WHITE, Color.BLACK);
        fields[5] = new ShippingField("Redderiget Lindinger A/S", Color.blue, Color.black, 2,rent, 4000);
        fields[6] = new BuildableField("RoskildeVej", Color.orange, Color.black, 1,rent, 2000, 1000);
        fields[7] = new ChanceField("Chance",Color.black, Color.green);
        fields[8] = new BuildableField("Valby Langgade", Color.orange, Color.black, 3, rent, 2000, 1000);
        fields[9] = new BuildableField("Allégade", Color.orange, Color.black, 3,rent, 2400, 1000);
        fields[10] = new RefugeField("På besøg", Color.black, Color.white);
        fields[11] = new BuildableField("Frederiksberg Allé", Color.green, Color.black, 3,rent, 2800, 2000);
        fields[12] = new BreweryField("Tuborg", Color.red, Color.black, 3,rent, 3000);
        fields[13] = new BuildableField("Bülowsvej", Color.green, Color.black, 3,rent, 2800, 2000);
        fields[14] = new BuildableField("Gl. Kongevej", Color.green, Color.black, 3,rent, 3200, 2000);
        fields[15] = new ShippingField("Mols - Linien", Color.RED, Color.black, 4,rent, 4000);
        fields[16] = new BuildableField("Bernstorffsvej", Color.gray, Color.black, 3,rent, 3600, 2000);
        fields[17] = new ChanceField("Chance", Color.black, Color.green);
        fields[18] = new BuildableField("Hellerupvej", Color.gray, Color.black, 3,rent, 3600, 2000);
        fields[19] = new BuildableField("Strandvejen", Color.gray, Color.black, 3,rent, 4000, 2000);
        fields[20] = new RefugeField("Parkering", Color.blue, Color.black);
        fields[21] = new BuildableField("Trianglen", Color.red, Color.black, 3,rent, 4400, 3000);
        fields[22] = new ChanceField("Chance", Color.black, Color.green);
        fields[23] = new BuildableField("Østerbrogade", Color.red, Color.black, 3,rent, 4400, 3000);
        fields[24] = new BuildableField("Grønningen", Color.RED, Color.black, 3,rent, 4800, 3000);
        fields[25] = new BuildableField("Gedser-Rostock", Color.BLUE, Color.black, 3,rent, 4000, 1000);
        fields[26] = new BuildableField("Bredgade", Color.WHITE, Color.black, 3,rent, 5200, 3000);
        fields[27] = new BuildableField("Kgs Nytorv", Color.WHITE, Color.black, 3,rent, 5200, 3000);
        fields[28] = new BreweryField("Carlsberg", Color.RED, Color.black, 3,rent, 3000);
        fields[29] = new BuildableField("Østergade", Color.WHITE, Color.black, 3,rent, 5600, 3000);
        fields[30] = new PrisonField("De fængsles", Color.black, Color.white);
        fields[31] = new BuildableField("Amagertorv", Color.YELLOW, Color.black, 3,rent, 6000, 4000);
        fields[32] = new BuildableField("Vimmelskaftet", Color.YELLOW, Color.black, 3,rent, 6000, 4000);
        fields[33] = new ChanceField("Chance", Color.BLACK, Color.green);
        fields[34] = new BuildableField("Nygade", Color.YELLOW, Color.black, 3,rent, 6000, 4000);
        fields[35] = new BuildableField("Rødby-Puttgarden", Color.BLUE, Color.black, 3,rent, 4000, 1000);
        fields[36] = new ChanceField("Chance", Color.BLACK, Color.green);
        fields[37] = new BuildableField("Frederiksberggade", Color.PINK, Color.black, 3,rent, 7000, 4000);
        fields[38] = new GovTaxField("Statsskat", Color.BLUE, Color.black);
        fields[39] = new BuildableField("Rådhuspladsen", Color.PINK, Color.black, 3,rent, 8000, 4000);       

    }

    public Field[] getFields() {
        return fields;
    }
}
