package spil;

import java.awt.*;

public class BuildableField extends OwnableField {

    private int buildingPrice;

    public BuildableField (String newName, String newSubText, String newDescription, Color primary, Color secondary, int newType, int newGroup, int[] newRent, int price, int newBuildingPrice){
        super(newName, newSubText, newDescription, primary, secondary, newType, newGroup,newRent, price);
        buildingPrice = newBuildingPrice;
        buildable = true;
    }

    @Override
    public void landOnField(Player landingPlayer) {
        // to do
    }

    public void Build(){
        // to do
    }

    @Override
    public String getPriceString() {
        return super.getPriceString();
    }
}
