package game;

import game.controllers.*;
import game.controllers.ChanceCardController;
import game.controllers.fields.notownable.PrisonController;
import game.controllers.fields.notownable.TaxController;
import game.model.*;
import game.model.fields.*;
import game.controllers.fields.ownable.*;
import game.view.GUIController;

public class MasterController {
	// important numbers for the game
	public static final int PLAYER_STARTBALANCE = 30000;
	public static final int GAME_PLAYERS_MAX = 6;
	public static final int GAME_PLAYERS_MIN = 2;
	
	// instantiation of game.controllers
	private DiceController cup = new DiceController();
	private GUIController guiC = GUIController.getInstance();
	private BoardController board = new BoardController();
	private PlayerController pc = new PlayerController();
	private ChanceCardController ccc = new ChanceCardController();

	//Fieldcontrollers
    private BreweryController fbC = new BreweryController();
    private ShippingController fsC = new ShippingController();
    private BuildableController fBC = new BuildableController();
    private PrisonController fpC = new PrisonController();
    private TaxController ftC = new TaxController();


	private int currentTurn = 0;
	
	
	
	private void init() {
		guiC.initFields(board.getFields());
		pc.makePlayers(guiC.makePlayers());
        guiC.updateGUI(pc.getPlayers(), cup.getFaces(), board.getFields());
	}
	
	private void go() {
		//gameLoop


		while (true) {
            Player curPlayer = pc.getPlayer(currentTurn);
			guiC.getOk(Language.roll(curPlayer));
            int stashedRoll = 0;


			if(!curPlayer.isBankrupt()){
			    while(!curPlayer.isFree()){
                    guiC.getOk(Language.currentlyJailed());
                    if (guiC.getYesNo(Language.payBail())) {
                        curPlayer.payMoney(1000);
                        curPlayer.setFree(true);
                        break;
                    }
                    if (curPlayer.getJailCard()>0) {
                        if(guiC.getYesNo(Language.useJailCard())){
                            curPlayer.removeJailCard(1);
                            curPlayer.setFree(true);
                            break;
                        }
                    }
                    guiC.getOk(Language.rollForJail());
                    cup.roll();
                    guiC.updateDice(cup.getFaces());
                    guiC.getOk(Language.diceThrowFormat(cup.getFaceValue()));
                    if(cup.getDouble()){
                        stashedRoll = cup.getFaceValue();
                        guiC.getOk(Language.jailEscapeSuccess());
                        curPlayer.setFree(true);
                        break;
                    } else {
                        guiC.getOk(Language.jailEscapeFail());
                        curPlayer.setJailRollAmount(curPlayer.getJailRollAmount()+1);
                        if(curPlayer.getJailRollAmount()==3){
                            stashedRoll = cup.getFaceValue();
                            guiC.getOk(Language.jailTooLong());
                            curPlayer.payMoney(1000);
                            curPlayer.setFree(true);
                        }
                        break;
                    }
                }
                if(curPlayer.isFree()) {

			        if (stashedRoll > 0) {
                        pc.getPlayer(currentTurn).move(stashedRoll);
                    } else {
                        pc.getPlayer(currentTurn).move(cup.roll());
                    }

                    board.setAllVals(pc.getPlayers());

                    guiC.updateGUI(pc.getPlayers(), cup.getFaces(), board.getFields());

                    landOnField(curPlayer);

                    guiC.updateGUI(pc.getPlayers(), cup.getFaces(), board.getFields());

                }
			} else {
			    guiC.getOk(Language.bankrupt());
            }
			currentTurn = (currentTurn + 1) % (pc.getPlayers().length);
		}
	}
	private void landOnField(Player landingPlayer){
		Field currentField = board.getField(landingPlayer.getLocation());
		// if start do nothing
		
		// if ChanceField
		if(currentField.getType()==100){
			guiC.getOk(ccc.resolveChance(landingPlayer, pc.getPlayers(), board.getFields()));
		}
		// if IncomeTaxField
		if(currentField.getType()==2){
			ftC.landOnField(landingPlayer,currentField);
		}
		// if buildable
		if (currentField.getType()==4){
            fBC.landOnField(landingPlayer,currentField);
		}
		//if brewery
		if (currentField.getType() == 5){
		    fbC.landOnField(landingPlayer,currentField);
		}
		// if shipping
        if (currentField.getType() == 6){
            fsC.landOnField(landingPlayer,currentField);
        }
        // if shipping
        if (currentField.getType() == 8){
            fpC.landOnField(landingPlayer,currentField);
        }
	}

	
	
	
	
	
	public static void main(String[] args)  {
		MasterController mc = new MasterController();
		mc.init();
		mc.go();
	}
}
