package controllers;

import model.*;
import fields.*;

public class ChanceCardController {
	private ChanceCardController chanceCardController = new ChanceCardController();
	private Field[] fields = Board.getInstance().getFields(); //henvisning til fields i Board klassen
	private Player[] players = ModelController.getInstance().getPlayers(); //henvisning til spillerne i ModelController klassen
	
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
	
	public void resolveChance(ChanceCard chanceCard, Player drawingPlayer){
		switch (chanceCard.getID()){
		case 1:
			drawingPlayer.receiveMoney(3000);
			break;
			
		case 2:
			for (int i = 0; i <players.length ; i++){
				players[i].payMoney(-500);
				drawingPlayer.receiveMoney(500);
			}
			break;
			
		case 3:	
			drawingPlayer.forceMove(0);
			break;
			
		case 4:
			drawingPlayer.forceMove(drawingPlayer.getLocation()-3);
			break;
			
		case 5:
		
			break;
			
		case 6:
		
			break;
			
		case 7:
			
			break;
			
		case 8:
		
			break;
			
		case 9:
		
			break;
			
		case 10:
		
			break;
			
		case 11:
			
			break;
			
		case 12:
			
			break;
			
		case 13:

			break;
			
		case 14:
			
			break;
			
		case 15:
			
			break;
			
		case 16:
			
			break;
			
		case 17:
			
			break;
			
		case 18:
			
			break;
			
		case 19:
		
			break;
			
		case 20:
			
			break;
			
		case 21:
			
			break;
			
		case 22:

			break;
			
		case 23:
			
			break;
		}
		
		
	}
	
	
}
