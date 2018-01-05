package model;

public class ChanceCard {

	private static int counter = 0;
	private int iD;
	
	public ChanceCard() {
		iD = counter % 44;
		counter++;
	}
	
	public int getID(){
		return iD;
	}
}
