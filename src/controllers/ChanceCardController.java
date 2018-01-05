package controllers;

import model.ChanceCard;

public class ChanceCardController {
	private ChanceCardController chanceCardController = new ChanceCardController();
	
	private ChanceCardController() {
		
	}
	public ChanceCardController getChanceController() {
		return chanceCardController;
	}
	
	public ChanceCard[] getNewCards() {
		ChanceCard[] cards = new ChanceCard[44];
		for (int i = 0 ; i < 44; i++)
			cards[i] = new ChanceCard();
		return cards;
	}
	
}
