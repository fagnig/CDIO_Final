package game;

import game.controllers.*;
import game.controllers.ChanceCardController;
import game.controllers.fields.notownable.PrisonController;
import game.controllers.fields.notownable.TaxController;
import game.model.*;
import game.model.fields.*;
import game.controllers.fields.ownable.*;
import game.model.fields.notownable.ChanceField;
import game.model.fields.notownable.PrisonField;
import game.model.fields.notownable.TaxField;
import game.model.fields.ownable.BreweryField;
import game.model.fields.ownable.BuildableField;
import game.model.fields.ownable.OwnableField;
import game.model.fields.ownable.ShippingField;
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
	private int multiRoll = 0;
	
	
	private void init() {
		Field[] fields = board.getFields();
		guiC.initFields(fields);
		String[] names = guiC.makePlayers();
		pc.makePlayers(names);
		Player[] players = pc.getPlayers();
        guiC.updateGUI(pc.getPlayers(), cup.getFaces(), board.getFields());
	}
	
	private void go() {
		//gameLoop
        boolean gameRunning = false;

        int winningPlayerIndex = 0;

		while (gameRunning) {
            Player curPlayer = pc.getPlayer(currentTurn);
            int stashedRoll = 0;
            int index = 0;
            boolean wantToBuild = false;
            BuildableField[] tempFields;

			if(!curPlayer.isBankrupt()){
                guiC.getOk(Language.roll(curPlayer));

                /*
                //byggecond aka noget værre lort
                for(int j = 0; j < curPlayer.getOwnedFields().length;j++) {
                    for (int i = 0; i < board.getFields().length; i++) {
                        if (curPlayer.getOwnedFields()[j]==board.getFields()[i]) {
                            if (curPlayer.getOwnedFields()[j] instanceof BuildableField){
                                if (board.canBuild(i)) {
                                    index++;
                                }
                            }
                        }
                    }
                }
                if(index>0) {
                    tempFields = new BuildableField[index];
                    int counter = 0;
                    for (int j = 0; j < curPlayer.getOwnedFields().length; j++) {
                        for (int i = 0; i < board.getFields().length; i++) {
                            if (curPlayer.getOwnedFields()[j] == board.getField(i)) {
                                if (board.canBuild(i)) {
                                    tempFields[counter++] = (BuildableField) board.getField(i);
                                }
                            }
                        }
                    }
                    if(guiC.getYesNo(Language.wantToBuild())){
                        wantToBuild = true;
                    }
                    while(wantToBuild){
                        BuildableField result = guiC.chooseFieldBuild(Language.chooseForBuild(),tempFields);
                        if(result.getBuildingPrice()<curPlayer.getBalance()){
                            result.setBuildStatus(result.getBuildStatus()+1);
                            curPlayer.payMoney(result.getBuildingPrice());
                        } else {
                            guiC.getOk(Language.notEnoughMoney());
                        }
                    }
                }
                //Slut på lort
                */



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
                        if(cup.getDouble()&&multiRoll==2){
                            guiC.getOk(Language.tooLucky());
                            curPlayer.forceMove(10);
                            curPlayer.setFree(false);
                        }
                    }

                    board.setAllVals(pc.getPlayers());

                    guiC.updateGUI(pc.getPlayers(), cup.getFaces(), board.getFields());

                    landOnField(curPlayer);

                    //Bankruptcy check
                    for(int i = 0; i<pc.getPlayers().length; i++){
                        if(pc.getPlayers()[i].getBalance()<0){
                            if(!(Math.abs(pc.getPlayers()[i].getBalance())>pc.getPlayers()[i].getTotalValue())){
                                while(pc.getPlayers()[i].getBalance()<0) {
                                    OwnableField result = guiC.chooseFieldMortgage(Language.chooseForMortgage(pc.getPlayers()[i].getBalance()), pc.getPlayers()[i].getOwnedFields());
                                    pc.getPlayers()[i].receiveMoney(result.getPrice()/2);
                                    result.setMortgaged(true);
                                }
                            } else {
                                guiC.getOk(Language.bankrupt());
                                pc.getPlayers()[i].setBankrupt(true);
                            }
                        }
                    }

                    //Should the game end?
                    int count = 0;
                    for(int i = 0; i<pc.getPlayers().length; i++){
                        if(!pc.getPlayers()[i].isBankrupt()){
                            count++;
                            winningPlayerIndex = i;
                        }
                    }
                    if(count>1){
                        gameRunning = false;
                    }

                    guiC.updateGUI(pc.getPlayers(), cup.getFaces(), board.getFields());

                }

			}

            if(!cup.getDouble()) {
                currentTurn = (currentTurn + 1) % (pc.getPlayers().length);
                multiRoll = 0;
            } else {
			    if(multiRoll<2) {
                    multiRoll += 1;
                } else {
			        multiRoll = 0;
                    currentTurn = (currentTurn + 1) % (pc.getPlayers().length);
                }
            }
		}
        //Game end
        guiC.getOk(Language.gameEnd(pc.getPlayer(winningPlayerIndex)));
		System.exit(0);
	}
	private void landOnField(Player landingPlayer){
		Field currentField = board.getField(landingPlayer.getLocation());
		// if start do nothing
		
		// if ChanceField
		if(currentField instanceof ChanceField){
			guiC.getOk(ccc.resolveChance(landingPlayer, pc.getPlayers(), board.getFields()));
		}else if(currentField instanceof TaxField){
			ftC.landOnField(landingPlayer,currentField);
		}else if (currentField instanceof BuildableField){
            fBC.landOnField(landingPlayer,currentField);
		}else if (currentField instanceof BreweryField){
		    fbC.landOnField(landingPlayer,currentField);
		}else if (currentField instanceof ShippingField){
            fsC.landOnField(landingPlayer,currentField);
        }else if (currentField instanceof PrisonField){
            fpC.landOnField(landingPlayer,currentField);
        } else {
		    guiC.getOk(Language.safeField());
        }
	}

	
	
	
	
	
	public static void main(String[] args)  {
		MasterController mc = new MasterController();
		mc.init();
		mc.go();
	}
}
