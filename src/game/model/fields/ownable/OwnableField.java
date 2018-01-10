package game.model.fields.ownable;

import java.awt.*;

import game.model.Player;
import game.model.fields.Field;

public abstract class OwnableField extends Field {

    protected int price,group, type;
    protected int[] rent  = new int[6];
    protected Player owner;
    protected Boolean buildable = false;
    protected int amountOwned = 1;

    public OwnableField (String newName, Color primary, Color secondary, int newGroup, int[] newRent, int newPrice){
        super(newName, primary, secondary);
        rent = newRent;
        group = newGroup;
        price = newPrice;
    }

    public String getPriceString(){
        return Integer.toString(price);
    }
    public int[] getRent(){
    	return rent;
    }
    public Player getOwner(){
    	return owner;
    }
    
    public int getPrice(){
    	return price;
    }
    public void setOwner(Player player){
    	owner = player;
    }
    public int getGroup(){
    	return group;
    }

    public void setPrice(int amount){
        rent[0] = amount;
    }

    public int getAmountOwned(){
        return amountOwned;
    }
    public void setAmountOwned(int amount){
        amountOwned = amount;
    }
}
