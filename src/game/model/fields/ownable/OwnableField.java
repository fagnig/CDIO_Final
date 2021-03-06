package game.model.fields.ownable;

import java.awt.*;

import game.model.Player;
import game.model.fields.Field;

public abstract class OwnableField extends Field {

    protected int price,group;
    protected int[] rent;
    protected Player owner;
    protected boolean mortgaged = false;
    protected int amountOwned;

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

    public boolean isMortgaged(){
        return mortgaged;
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

    public int getAmountOwned(){
        return amountOwned;
    }
    public void setAmountOwned(int amount){
        amountOwned = amount;
    }

    public void setMortgaged(boolean b) {
        mortgaged = b;
    }

    public int getValue() {
        return price;
    }
}
