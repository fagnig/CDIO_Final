package spil;

import java.awt.*;

public class ShippingField extends OwnableField {
    public ShippingField(String newName, String newSubText, String newDescription, Color primary, java.awt.Color secondary, int newType, int newGroup, int[] newRent, int newPrice){
        super(newName, newSubText, newDescription, primary, secondary, newType, newGroup,newRent, newPrice);
    }

    @Override
    public void landOnField(Player landingPlayer) {
        // to do
    }

    @Override
    public String getPriceString() {
        return super.getPriceString();
    }
}
