package game;

import game.controllers.*;
import game.model.*;
import game.model.fields.*;
import game.model.fields.ownable.BreweryField;
import game.model.fields.ownable.BuildableField;
import game.model.fields.ownable.ShippingField;
import game.view.GUIController;

public class MasterController {
	// important numbers for the game
	public static final int PLAYER_STARTBALANCE = 30000;
	public static final int GAME_PLAYERS_MAX = 6;
	public static final int GAME_PLAYERS_MIN = 2;
	
	// instantiation of game.controllers
	private DiceController cup = new DiceController();
	private GUIController guiC = new GUIController();
	private BoardController board = new BoardController();
	private PlayerController pc = new PlayerController();
	private ChanceCardController ccc = new ChanceCardController();
	private Player[] players;
	private int currentTurn = 0;
	
	
	
	private void init() {
		guiC.initFields(board.getFields());
		players = pc.makePlayers(guiC.makePlayers());
		
		
	}
	
	private void go() {
		//gameLoop

		while (true) {
			guiC.getOk(Language.roll());
			players[currentTurn].move(5);
			guiC.updateGUI(players,cup.getFaces());
			landOnField(players[currentTurn]);
            guiC.updateGUI(players,cup.getFaces());
			currentTurn = (currentTurn + 1) % (players.length);
		}
	}
	private void landOnField(Player landingPlayer){
		Field currentField = board.getField(landingPlayer.getLocation());
		// if start do nothing
		
		// if ChanceField
		if(currentField.getType()==100){
			guiC.getOk(ccc.resolveChance(landingPlayer, players, board.getFields()));
		}
		// if IncomeTaxField
		if(currentField.getType()==2){
			if(guiC.getTaxChoice(Language.taxType())){
				landingPlayer.payMoney(landingPlayer.getBalance()/10);
			}
			else{
				landingPlayer.payMoney(4000);
			}
		}
		
		
		// if govTaxField
		if(currentField.getType()==3){
			landingPlayer.payMoney(4000);
		}
		
		
		// if buildable
		if (currentField.getType()==4){
			BuildableField castedField = ((BuildableField) currentField);
			if (castedField.getOwner() == null){
				if(guiC.getYesNo(Language.wantToBuy(castedField))){
					castedField.setOwner(landingPlayer);
					landingPlayer.payMoney(castedField.getPrice());
				}
			} else {
				int mult = 1;
				if (board.areAllOwned(castedField.getOwner(),castedField.getGroup())){
					mult = 2;
				}
				int rent = castedField.getRent()[castedField.getBuildStatus()]*mult;
				guiC.getOk(landingPlayer.getName()  + Language.payRent() + castedField.getOwner().getName()+ " "+ rent);
				landingPlayer.payMoney(rent);
				castedField.getOwner().receiveMoney(rent);
				
			}
		}
		
		//if brewery
		if (currentField.getType() == 5){
			BreweryField castedField = ((BreweryField) currentField);
			if (castedField.getOwner() == null){
				if(guiC.getYesNo(Language.wantToBuy(castedField))){
					castedField.setOwner(landingPlayer);
					landingPlayer.payMoney(castedField.getPrice());
				}
			} else {
				int mult = 1;
				if (board.areAllOwned(landingPlayer,(castedField.getGroup()))){
					mult = 2;
				}

				int rent = cup.getFaceValue()*100*mult;
                guiC.getOk(landingPlayer.getName()  + Language.payRent() + castedField.getOwner().getName()+ " "+ rent);
				landingPlayer.payMoney(rent);
				castedField.getOwner().receiveMoney(rent);
			}
		
		}
		
		// if shipping
        if (currentField.getType() == 6){
            ShippingField castedField = ((ShippingField) currentField);
            if (castedField.getOwner() == null){
                if(guiC.getYesNo(Language.wantToBuy(castedField))){
                    castedField.setOwner(landingPlayer);
                    landingPlayer.payMoney(castedField.getPrice());
                }
            } else {

                int rent = castedField.getRent()[board.shippingOwned(castedField.getOwner())];
                guiC.getOk(landingPlayer.getName()  + Language.payRent() + castedField.getOwner().getName()+ " "+ rent);
                landingPlayer.payMoney(rent);
                castedField.getOwner().receiveMoney(rent);
            }

        }
	
	}

	
	
	
	
	
	public static void main(String[] args)  {
		MasterController mc = new MasterController();
		mc.init();
		mc.go();
	}
}
