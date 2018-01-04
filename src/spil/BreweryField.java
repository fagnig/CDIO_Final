package spil;

import java.awt.*;

public class BreweryField extends OwnableField {

    public BreweryField (String newName, String newSubText, String newDescription, Color primary, Color secondary, int newType, int newGroup, int[] newRent, int newPrice) {
        super(newName, newSubText, newDescription, primary, secondary, newType, newGroup, newRent, newPrice);
        buildable = false;
    }

    @Override
    public void landOnField(Player landingPlayer) {

    }

    @Override
    public String getPriceString() {
        return super.getPriceString();
    }
}
