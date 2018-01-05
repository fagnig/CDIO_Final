package fields;

import java.awt.*;

import model.Player;

public class BuildableField extends OwnableField {

    private int buildingPrice;

    public BuildableField (String newName, Color primary, Color secondary,  int newGroup, int[] newRent, int price, int newBuildingPrice){
        super(newName, primary, secondary, newGroup,newRent, price);
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
