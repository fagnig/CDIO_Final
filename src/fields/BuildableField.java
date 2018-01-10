package fields;

import java.awt.*;

import model.Language;
import model.Player;

public class BuildableField extends OwnableField {

    private int buildingPrice, buildStatus;

    public BuildableField (String newName, Color primary, Color secondary,  int newGroup, int[] newRent, int price, int newBuildingPrice){
        super(newName, primary, secondary, newGroup,newRent, price);
        buildingPrice = newBuildingPrice;
        buildable = true;
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
    
    public int getType() {
    	return type;
    }

    @Override
    public String getPriceString() {
        return super.getPriceString();
    }
    public void setOwner(Player newOwner){
    	owner = newOwner;
    }

	public Player getOwner() {
		return owner;
	}
	public int getPrice(){
		return price;
	}
	public int getBuildStatus(){
		return buildStatus;
	}



    
}
