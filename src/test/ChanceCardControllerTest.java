package test;
	import game.model.*;

	import java.util.Random;

	import game.model.fields.*;
	import game.model.fields.ownable.ShippingField;
public class ChanceCardControllerTest {




		private Random random = new Random();
		
		public ChanceCardControllerTest() {
			
		}
		
		public String resolveChance(int number, Player drawingPlayer, Player[] players, Field[] fields ){
			
			String[] returnValues = Language.chanceStrings();
			switch (number){
			case 1:
				//Modtag 3000 kr. af banken
				drawingPlayer.receiveMoney(3000);
				return returnValues[number-1];
				
			case 2:
				//Modtag 500 kr. fra hver spiller
	            for (Player player : players) {
	                player.payMoney(500);
	                drawingPlayer.receiveMoney(500);
	            }
	            return returnValues[number-1];
				
			case 3:	
				//Ryk hen til start
				drawingPlayer.forceMove(0);
	            return returnValues[number-1];

				
			case 4:
				//Ryk 3 felter tilbage
				drawingPlayer.forceMove(drawingPlayer.getLocation()-3);
	            return returnValues[number-1];

				
			case 5:
				//Modtag 1000 kr. af banken
				drawingPlayer.receiveMoney(1000);
	            return returnValues[number-1];

				
			case 6:
				//Modtag 200 kr. af banken
				drawingPlayer.receiveMoney(200);
	            return returnValues[number-1];

				
			case 7:
				//Betal 1000 kr.
				drawingPlayer.payMoney(1000);
	            return returnValues[number-1];

				
			case 8:
				//Ryk 3 felter frem
				drawingPlayer.forceMove(drawingPlayer.getLocation()+3);
	            return returnValues[number-1];

				
			case 9:
				//Betal 3000 kr.
				drawingPlayer.payMoney(3000);
	            return returnValues[number-1];

				
			case 10:
				//Betal 300 kr.
				drawingPlayer.payMoney(300);
	            return returnValues[number-1];

				
			case 11:
				//Betal 2000 kr.
				drawingPlayer.payMoney(2000);
	            return returnValues[number-1];

				
			case 12:
				//Modtag 200 kr. fra hver spiller
	            for (Player player : players) {
	                player.payMoney(200);
	                drawingPlayer.receiveMoney(200);
	            }
	            return returnValues[number-1];

				
			case 13:
				//Ryk i fængsel
				drawingPlayer.forceMove(10);
				drawingPlayer.setFree(false);
	            return returnValues[number-1];

				
			case 14:
				//Modtag 500 kr.
				drawingPlayer.receiveMoney(500);
	            return returnValues[number-1];

				
			case 15:
				//Ryk til den nærmeste færge, modtag 4000 hvis start passeres
				while(true) {
				drawingPlayer.forceMove(drawingPlayer.getLocation()+1);
				if (fields[drawingPlayer.getLocation()] instanceof ShippingField)
					break;
				}
	            return returnValues[number-1];

				
			case 16:
				//Ryk til Mols-linjen, modtag 4000 hvis start passeres
				drawingPlayer.forceMove(15);
				//Mangler check
	            return returnValues[number-1];

				
			case 17:
				//Ryk frem til Frederiksberg allé modtag 4000 hvis start passeres
				drawingPlayer.forceMove(11);
				//Mangler check
	            return returnValues[number-1];

				
			case 18:
				//Ryk frem til Strandvejen, modtag 4000 hvis start passeres
				drawingPlayer.forceMove(19);
	            return returnValues[number-1];

				
			case 19:
				//Ryk frem til Rådhuspladsen
				drawingPlayer.forceMove(39);
	            return returnValues[number-1];
				
			case 20:
				//Ryk frem til Vimmelskaftet, modtag 4000 hvis start passeres
				drawingPlayer.forceMove(32);
				//Mangler check
	            return returnValues[number-1];

				
			case 21:
				//Ryk frem til Grønningen, modtag 4000 hvis start passeres
				drawingPlayer.forceMove(24);
				//Mangler check
	            return returnValues[number-1];

				
			case 22:
				//Betal 200 kr.
				drawingPlayer.payMoney(200);
	            return returnValues[number-1];

				
			case 23:
				//Spiller får et fængselskort
				drawingPlayer.addJailCard(1);
	            return returnValues[number-1];

			}
			
			return Language.error();
		}
		
		
	}


