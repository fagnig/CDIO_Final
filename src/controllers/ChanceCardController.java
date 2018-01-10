package controllers;

import model.*;

import java.util.Random;

import fields.*;

public class ChanceCardController {
	private Random random = new Random();
	
	public ChanceCardController() {
		
	}

	
	public ChanceCard[] getNewCards() {
		ChanceCard[] cards = new ChanceCard[44];
		for (int i = 0 ; i < 44; i++)
			cards[i] = new ChanceCard();
		return cards;
	}
	
	public void resolveChance(Player drawingPlayer, Player[] players, Field[] fields ){
		int number = random.nextInt(23)+1;
		switch (number){
		case 1:
			//Modtag 3000 kr. af banken
			drawingPlayer.receiveMoney(3000);
			break;
			
		case 2:
			//Modtag 500 kr. fra hver spiller
			for (int i = 0; i <players.length ; i++){
				players[i].payMoney(500);
				drawingPlayer.receiveMoney(500);
			}
			break;
			
		case 3:	
			//Ryk hen til start
			drawingPlayer.forceMove(0);
			break;
			
		case 4:
			//Ryk 3 felter tilbage
			drawingPlayer.forceMove(drawingPlayer.getLocation()-3);
			break;
			
		case 5:
			//Modtag 1000 kr. af banken
			drawingPlayer.receiveMoney(1000);
			break;
			
		case 6:
			//Modtag 200 kr. af banken
			drawingPlayer.receiveMoney(200);
			break;
			
		case 7:
			//Betal 1000 kr.
			drawingPlayer.payMoney(1000);
			break;
			
		case 8:
			//Ryk 3 felter frem
			drawingPlayer.forceMove(drawingPlayer.getLocation()+3);
			break;
			
		case 9:
			//Betal 3000 kr.
			drawingPlayer.payMoney(3000);
			break;
			
		case 10:
			//Betal 300 kr.
			drawingPlayer.payMoney(300);
			break;
			
		case 11:
			//Betal 2000 kr.
			drawingPlayer.payMoney(2000);
			break;
			
		case 12:
			//Modtag 200 kr. fra hver spiller
			for (int i = 0; i <players.length ; i++){
				players[i].payMoney(200);
				drawingPlayer.receiveMoney(200);
			}
			break;
			
		case 13:
			//Ryk i fængsel
			drawingPlayer.forceMove(10);
			break;
			
		case 14:
			//Modtag 500 kr.
			drawingPlayer.receiveMoney(500);
			break;
			
		case 15:
			//Ryk til den nærmeste færge, modtag 4000 hvis start passeres
			while(true) {
			drawingPlayer.forceMove(drawingPlayer.getLocation()+1);
			if (fields[drawingPlayer.getLocation()].getType() == 6)
				break;
			}
			break;
			
		case 16:
			//Ryk til Mols-linjen, modtag 4000 hvis start passeres
			drawingPlayer.forceMove(15);
			//Mangler check
			break;
			
		case 17:
			//Ryk frem til Frederiksberg allé modtag 4000 hvis start passeres
			drawingPlayer.forceMove(11);
			//Mangler check
			break;
			
		case 18:
			//Ryk frem til Strandvejen, modtag 4000 hvis start passeres
			drawingPlayer.forceMove(19);
			break;
			
		case 19:
			//Ryk frem til Rådhuspladsen
			drawingPlayer.forceMove(39);		
			break;
			
		case 20:
			//Ryk frem til Vimmelskaftet, modtag 4000 hvis start passeres
			drawingPlayer.forceMove(32);
			//Mangler check
			break;
			
		case 21:
			//Ryk frem til Grønningen, modtag 4000 hvis start passeres
			drawingPlayer.forceMove(24);
			//Mangler check
			break;
			
		case 22:
			//Betal 200 kr.
			drawingPlayer.payMoney(200);
			break;
			
		case 23:
			//Spiller får et fængselskort
			drawingPlayer.getWallet().addJailCard(1);
			break;
		}
		
		
	}
	
	
}
