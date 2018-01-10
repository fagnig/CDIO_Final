package game;

import game.controllers.*;
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

	//Field controllers
    private BreweryController fbC = new BreweryController();
    private ShippingController fsC = new ShippingController();
    private BuildableController fBC = new BuildableController();


	private int currentTurn = 0;
	
	
	
	private void init() {
		guiC.initFields(board.getFields());
		pc.makePlayers(guiC.makePlayers());
	}
	
	private void go() {
		//gameLoop
        int m=0;
		while (true) {
			guiC.getOk(Language.roll());

            pc.getPlayer(currentTurn).move(1);
			//pc.getPlayer(currentTurn).move(cup.roll());

			board.setAllVals(pc.getPlayers());

			guiC.updateGUI(pc.getPlayers(),cup.getFaces(),board.getFields());
            m++;
			guiC.setBuildStatus(1,m);
			landOnField(pc.getPlayer(currentTurn));

            guiC.updateGUI(pc.getPlayers(),cup.getFaces(),board.getFields());

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
	
	}

	
	
	
	
	
	public static void main(String[] args)  {
		MasterController mc = new MasterController();
		mc.init();
		mc.go();
	}
}
