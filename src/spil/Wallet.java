package spil;

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
}
