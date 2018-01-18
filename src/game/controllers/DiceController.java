package game.controllers;
import game.model.Dice;

public class DiceController {
	
	private Dice d1 = new Dice();
	private Dice d2 = new Dice();
	
	public DiceController() {
		
	}
	
	public int roll() {
		int value = d1.roll()+d2.roll();
		return 1;
		//return value;
	}
	
	public int getFaceValue(){
		return 1;
	    //return d1.getFaceValue()+d2.getFaceValue();
	}

	public boolean getDouble() {
		return false;
		/*if (d1.getFaceValue() == d2.getFaceValue()){
			return true;
		} else {
			return false;
		}*/
	}
	public int[] getFaces() {
		int[] faces = { d1.getFaceValue(), d2.getFaceValue()};
		return new int[] {1,1};
		//return faces;
	}
	


}
