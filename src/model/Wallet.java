package model;

public class Wallet {
    private int[] fields = new int[40];
    private int jailCard= 0;
    private int balance;

    public int getTotalValue(){
        //fill in
        return 1;
    }

    public void addMoney(int amount){
        balance = balance + amount;
    }

    public Wallet(int newBalance){
        balance = newBalance;
    }
    public void addJailCard(int amount) {
    	jailCard =+ amount;
    }
    public void removeJailCard(int amount) {
    	jailCard =- amount;
    }
    
    public int getJailCard() {
    	return jailCard;
    }
    public int getBalance() {
    	return balance;
    }
}
