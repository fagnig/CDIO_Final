package game.model.fields.ownable;

import java.awt.*;

import game.model.Language;

public class BuildableField extends OwnableField {

    private int buildingPrice, buildStatus;
    private boolean buildable;

    public BuildableField (String newName, Color primary, Color secondary,  int newGroup, int[] newRent, int price, int newBuildingPrice){
        super(newName, primary, secondary, newGroup,newRent, price);
        buildingPrice = newBuildingPrice;
        buildStatus = 0;
        buildable = false;
        subText = Integer.toString(price) ;
        description = Language.getFormattedDescription(rent,buildingPrice);
    }

    public int getBuildingPrice() {
    	return buildingPrice;
    }

    public void setBuildStatus(int status){
        buildStatus += status ;
    }

    public int getBuildStatus() {
        return buildStatus;
    }

    @Override
    public int getValue(){
        return price + buildingPrice*buildStatus;
    }

    public void setBuildable(boolean bool) {
        buildable = bool;
    }

    public boolean getBuildable() {
        return buildable;
    }
}
