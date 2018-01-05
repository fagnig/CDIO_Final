package fields;

import java.awt.*;

import model.Player;

public class BreweryField extends OwnableField {

    public BreweryField (String newName,  Color primary, Color secondary, int newGroup, int[] newRent, int newPrice) {
        super(newName, primary, secondary, newGroup, newRent, newPrice);
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
