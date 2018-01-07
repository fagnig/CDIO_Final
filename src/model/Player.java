package model;

import java.awt.Color;

import controllers.MasterController;

public class Player {

    private Wallet wallet;
    private String name;
//    private Color color;
    private Boolean free = true;
    private Boolean bankrupt = false;
    private int location = 0; 
 
    public Player(String newName) {
    	name = newName;
//    	color = newColor;
    	// oprettet et objekt af wallet typen. Forventer at få en start balance
    	wallet = new Wallet(MasterController.PLAYER_STARTBALANCE);
    }
    
    // Rykker spilleren fra forrige position til ny position.
    public void move(int distance) {
    	location = (location+distance)%40;
    }
    
    // "Teleporterer" spilleren til feltet.
    public void forceMove(int newLocation) {
    	location = newLocation%40;
    }
    
    public Boolean isFree() {
    	return free;
    }
    
    public Boolean isBankrupt() {
    	return bankrupt;
    }
    public void setFree(Boolean b) {
    	free = b;
    }
    
    public void setBankrupt(Boolean b) {
    	bankrupt = b;
    }
    public String getName() {
    	return name;
    }
//    public String getColor() {
//    	return color.toString();
//    }
    
    public void receiveMoney(int amount) {
    // kaldet på Wallet (metodekald)
    	wallet.addMoney(amount);
    }
    
    public void payMoney(int amount) {
        // kaldet på Wallet (metodekald)
        	wallet.addMoney(-amount);
        }

	public int getLocation() {
		return location;
	}
	public int getBalance() {
		return wallet.getBalance();
	}
}
