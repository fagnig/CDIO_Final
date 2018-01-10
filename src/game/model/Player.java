package game.model;


public class Player {

    private Wallet wallet;
    private String name;
    private Boolean free = true;
    private Boolean bankrupt = false;
    private int location = 0;
 
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
  
    public Wallet getWallet() {
    	return wallet;
    }
    
    public void setBankrupt(boolean b) {
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

	public int getLocation() {
		return location;
	}
	public int getBalance() {
		return wallet.getBalance();
	}
}
