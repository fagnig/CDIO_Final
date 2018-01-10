package game.controllers;
import game.model.Dice;

public class DiceController {
	
	private Dice d1 = new Dice();
	private Dice d2 = new Dice();
	
	public DiceController() {
		
	}
	
	public int roll() {
		int value = d1.roll()+d2.roll();
		return value;
	}
	
	public int getFaceValue(){
		return d1.getFaceValue()+d2.getFaceValue();
	}

	public boolean getDouble() {
		if (d1.getFaceValue() == d2.getFaceValue())
			return true;
		return false;
	}
	public int[] getFaces() {
		int[] faces = { d1.getFaceValue(), d2.getFaceValue()};
		return faces;
	}
	


}
