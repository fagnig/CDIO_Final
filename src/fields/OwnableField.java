package fields;

import java.awt.*;

import model.Player;

public abstract class OwnableField extends Field {

    protected int price,group, type;
    protected int[] rent  = new int[6];
    protected Player owner;
    protected Boolean buildable = false;

    public OwnableField (String newName, Color primary, Color secondary, int newGroup, int[] newRent, int newPrice){
        super(newName, primary, secondary);
        rent = newRent;
        group = newGroup;
        price = newPrice;
    }

    public abstract void landOnField(Player landingPlayer);

    public String getPriceString(){
        return Integer.toString(price);
    }
    public int[] getRent(){
    	return rent;
    }
}
