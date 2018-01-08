package fields;

import java.awt.*;

import model.Player;

public class BuildableField extends OwnableField {

    private int buildingPrice;

    public BuildableField (String newName, Color primary, Color secondary,  int newGroup, int[] newRent, int price, int newBuildingPrice){
        super(newName, primary, secondary, newGroup,newRent, price);
        buildingPrice = newBuildingPrice;
        buildable = true;
        type = 4;
        subText = "" + price ;
        description = "Leje: " + rent[0] +
				"\n 1 Hus: " + rent[1] +
				"\n 2 Huse: " + rent[2] +
				"\n 3 Huse: " + rent[3] +
				"\n 4 Huse: " + rent[4] +
				"\n Hotel: " + rent[5]+
				"\n pris på hus og hotel " + buildingPrice;
    }

    @Override
    public void landOnField(Player landingPlayer) {
        // to do
    }
    public int getBuildingPrice() {
    	return buildingPrice;
    }

    public void Build(){
        // to do
    }
    
    public int getType() {
    	return type;
    }

    @Override
    public String getPriceString() {
        return super.getPriceString();
    }
}
