package game.model;


import game.model.fields.ownable.OwnableField;

public class Player {

    private Wallet wallet;
    private String name;
    private Boolean free = true;
    private Boolean bankrupt = false;
    private int location = 0;
    private int jailRollAmount = 0;
 
    public Player(String newName, int Startbalance) {
    	name = newName;
    	// oprettet et objekt af wallet typen. Forventer at få en start balance
    	wallet = new Wallet(Startbalance);
    }
    
    // Rykker spilleren fra forrige position til ny position.
    public void move(int distance) {
    	location = (location+distance)%40;
    }
    
    // "Teleporterer" spilleren til feltet.
    public void forceMove(int newLocation) {
    	location = newLocation%40;
    }
    
    public boolean isFree() {
    	return free;
    }
    public boolean isBankrupt() {
    	return bankrupt;
    }
    public void setFree(boolean b) {
    	free = b;
    }
    
    public void setBankrupt(boolean b) {
    	bankrupt = b;
    }
    public String getName() {
    	return name;
    }
    
    public void receiveMoney(int amount) {
    // kaldet på Wallet (metodekald)
        if(amount < 0){
            amount = 0;
        }
        wallet.addMoney(amount);
    }
    public void payMoney(int amount) {
        // kaldet på Wallet (metodekald)
            if(amount < 0){
                amount = 0;
            }
        	wallet.removeMoney(amount);
    }
    public void addField(OwnableField newField){
        wallet.addField(newField);
    }

    public void removeField(OwnableField newField){
        wallet.removeField(newField);
    }
	public int getLocation() {
		return location;
	}
	public int getBalance() {
		return wallet.getBalance();
	}
	public int getTotalValue(){
        return wallet.getTotalValue();
    }

    public int getJailCard() {
        return wallet.getJailCard();
    }

    public int getJailRollAmount(){
        return jailRollAmount;
    }

    public void setJailRollAmount(int amount){
        jailRollAmount = amount;
    }

    public void removeJailCard(int amount) {
        wallet.removeJailCard(amount);
    }

    public void addJailCard(int amount){
        wallet.addJailCard(amount);
    }

    public OwnableField[] getOwnedFields(){
        return wallet.getOwnedFields();
    }

    public void setBalance(int amount) {
        wallet.setMoney(amount);
    }
}
