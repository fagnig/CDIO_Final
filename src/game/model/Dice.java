package game.model;

import java.util.Random;

public class Dice {
	private int faceValue;
	
	static Random dice = new Random();
	
	
	public int roll() {
		faceValue = dice.nextInt(6)+1;
		return faceValue;

	}
	public int getFaceValue() {
		return faceValue;
	}

}
