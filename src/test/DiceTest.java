package test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.controllers.DiceController;

public class DiceTest {
	DiceController cup = new DiceController();
	int numOfRolls = 10000;
	double[] spread = {0,0,1*numOfRolls/36,2*numOfRolls/36,3*numOfRolls/36,4*numOfRolls/36,5*numOfRolls/36,6*numOfRolls/36,5*numOfRolls/36,4*numOfRolls/36,3*numOfRolls/36,2*numOfRolls/36,1*numOfRolls/36};
	
	@Test
	
	//tests if the facevalue is ever over 12 or under 2 
	public void faceValueTest() {
		
		int[] result = new int[numOfRolls];
		for (int i = 0 ; i < numOfRolls ; i++ ) {
			result[i]=cup.roll();
		}
	for (int i = 0 ; i < numOfRolls ; i++ ) {
			assertTrue("outside bounds",(result[i]>1&&result[i]<13));
		}
	}
	
	@Test
	
	//tests that the dice roll fair, limit set high because we are using two random objects and not one 
	public void fairnessTest() {
		for (int numOfTests = 0 ; numOfTests < 100 ; numOfTests++) {
			int[] results = {0,0,0,0,0,0,0,0,0,0,0,0,0};
			for (int i = 0 ; i < numOfRolls ; i++ ) {
				results[cup.roll()]++;
			}
			for (int i = 0 ; i < 13 ; i++ ) {
				assertEquals("outside of expected range",spread[i],results[i],spread[i]*0.3);

			}
//			System.out.println("test run nr: " + numOfTests );
		}
	}

	@Test
	//tests the ammount of times we roll double, limit set high again because we use two random objects and not one
	public void doubleTest() {
		for( int j = 0 ; j<1000; j++) {
			int doubles = 0;
			for (int i = 0; i < numOfRolls; i++) {
				cup.roll();
				if (cup.getDouble())
					doubles++;
			}
			assertEquals("outside of expected Range " + j,numOfRolls/6,doubles,(numOfRolls/6)*0.1);
		}
	}

}
