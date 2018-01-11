package game.model.fields.ownable;

import java.awt.*;

import game.model.Language;

public class BuildableField extends OwnableField {

    private int buildingPrice, buildStatus;

    public BuildableField (String newName, Color primary, Color secondary,  int newGroup, int[] newRent, int price, int newBuildingPrice){
        super(newName, primary, secondary, newGroup,newRent, price);
        buildingPrice = newBuildingPrice;
        buildable = false;
        type = 4;
        buildStatus = 0;
        subText = Integer.toString(price) ;
        description = Language.getFormattedDescription(rent,buildingPrice);
    }

    public int getBuildingPrice() {
    	return buildingPrice;
    }

    public void setBuildStatus(int status){
        buildStatus += status ;
    }

	public int getBuildStatus(){
		return buildStatus;
	}

	public void setBuildable(boolean b){
        buildable = b;
    }

    public boolean getBuildable(){
        return buildable;
    }
}
