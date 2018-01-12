package game.model;

import game.model.fields.ownable.OwnableField;

public class Wallet {
    private OwnableField[] ownedFields = new OwnableField[0];
    private int jailCard= 0;
    private int balance;

    public int getTotalValue(){
        int tempVal = 0;
        if(balance > 0) {
            tempVal = balance;
        }
        for(int i = 0; i<ownedFields.length;i++){
            tempVal += ownedFields[i].getValue();
        }
        return tempVal;
    }

    public void addMoney(int amount){
        balance = balance + amount;
    }

    public void removeMoney(int amount){
        balance = balance - amount;
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

    public void addField(OwnableField newField){
        OwnableField[] tempFields = new OwnableField[ownedFields.length + 1];
        if(ownedFields.length == 0) {
            tempFields[0] = newField;
            ownedFields = tempFields;
        }else{
            for(int i = 0; i<ownedFields.length;i++){
                tempFields[i] = ownedFields[i];
            }
            tempFields[tempFields.length-1] =  newField;
            ownedFields = tempFields;
        }
    }

    public void removeField(OwnableField newField){
        boolean[] deleteField = new boolean[ownedFields.length];
        for(int i = 0; i<ownedFields.length;i++){
            if(ownedFields[i].equals(newField)) {
                deleteField[i]=true;
            } else {
                deleteField[i]=false;
            }
        }
        OwnableField[] tempFields = new OwnableField[ownedFields.length - 1];
        int index=0;
        for(int i=0;i<ownedFields.length;i++){
            if(!deleteField[i]){
                tempFields[index++]=ownedFields[i];
            }
        }
    }

    public OwnableField[] getOwnedFields() {
        return ownedFields;
    }

    public void setMoney(int amount) {
        balance = amount;
    }
}
