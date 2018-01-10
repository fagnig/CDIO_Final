package fields;

import java.awt.*;

import model.*;

public class BreweryField extends OwnableField {

    public BreweryField (String newName,  Color primary, Color secondary, int newGroup, int[] newRent, int newPrice) {
        super(newName, primary, secondary, newGroup, newRent, newPrice);
        buildable = false;
        type = 5;
    }

    @Override
    public String getPriceString() {
        return super.getPriceString();
    }
    public int getType() {
    	return type;
    }
    
}
