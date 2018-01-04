package spil;

import java.awt.*;

public abstract class OwnableField extends Field {

    protected int price,group, type;
    protected int[] rent  = new int[6];
    protected Player owner;
    protected Boolean buildable = false;

    public OwnableField (String newName, String newSubText, String newDescription, Color primary, Color secondary, int newType, int newGroup, int[] newRent, int newPrice){
        super(newName, newSubText, newDescription, primary, secondary, newType);
        rent = newRent;
        group = newGroup;
        price = newPrice;
    }

    public abstract void landOnField(Player landingPlayer);

    public String getPriceString(){
        return "" + price;
    }
}
