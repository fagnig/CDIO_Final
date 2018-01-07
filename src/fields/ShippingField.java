package fields;

import java.awt.*;

import model.Player;

public class ShippingField extends OwnableField {
	
    public ShippingField(String newName, Color primary, java.awt.Color secondary, int newGroup, int[] newRent, int newPrice){
        super(newName, primary, secondary, newPrice, newRent, newPrice);
        type = 6;
    }

    @Override
    public void landOnField(Player landingPlayer) {
        // to do
    }

    @Override
    public String getPriceString() {
        return super.getPriceString();
    }
    public int getType() {
    	return type;
    }
}

