package game.model;

public class ChanceCard {

	private static int counter = 0;
	private int iD;
	
	public ChanceCard() {
		iD = counter % 23;
		counter++;
	}
	
	public int getID(){
		return iD;
	}
}