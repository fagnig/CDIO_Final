package game;

import game.controllers.*;
import game.controllers.fields.notownable.*;
import game.model.*;
import game.model.fields.*;
import game.controllers.fields.ownable.*;
import game.model.fields.notownable.*;
import game.model.fields.ownable.*;
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

    /**
     *Initialises the GUI board and its players.
     * Also initialises the backend players.
     *
     * @see PlayerController
     * @see BoardController
     * @see GUIController
     */
	private void init() {
		Field[] fields = board.getFields();
		guiC.initFields(fields);
		String[] names = guiC.makeGUIPlayers();
		pc.makePlayers(names);

        guiC.updateGUI(pc.getPlayers(), cup.getFaces(), board.getFields());
	}

    /**
     * The main gameloop
     * Ensures the player knows what is happening, moving the players and that fields are resolved properly.
     * Players are removed from the game when they are unable to stay above 0 balance.
     * Stops the game when one player remains.
     */
	private void go() {
		//gameLoop
        boolean gameRunning = true;

        int winningPlayerIndex = 0;

		while (gameRunning) {
            Player curPlayer = pc.getPlayer(currentTurn);
            int stashedRoll = 0;
            boolean canBuild;
            boolean wantToBuild = false;


			if(!curPlayer.isBankrupt()){
                guiC.getOk(Language.roll(curPlayer));

                canBuild = pc.canPlayerBuild(curPlayer);
                if (canBuild) {
                    if (guiC.getYesNo(Language.wantToBuild())) {
                        wantToBuild = true;
                    }
                }

                while(wantToBuild && canBuild) {
                    BuildableField buildField = (BuildableField) guiC.chooseFieldBuild(Language.chooseForBuild(), curPlayer.getOwnedFields());
                    curPlayer.payMoney(buildField.getBuildingPrice());
                    buildField.setBuildStatus(buildField.getBuildStatus() + 1);
                    wantToBuild = guiC.getYesNo(Language.continueBuild());
                    board.setAllVals(pc.getPlayers());
                    canBuild = pc.canPlayerBuild(curPlayer);
                }

                //If in jail
			    if(!curPlayer.isFree()){
                    stashedRoll = jailTurn(curPlayer, stashedRoll);
                }

                if(curPlayer.isFree()) {
			        //Startfield money test
			        int oldLoc = curPlayer.getLocation();

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

                    curPlayer.setLastRoll(cup.getFaceValue());

                    board.setAllVals(pc.getPlayers());

                    guiC.updateGUI(pc.getPlayers(), cup.getFaces(), board.getFields());

                    //Recieve money for passing start
                    oldLoc = checkPassStart(curPlayer, oldLoc);

                    guiC.updateGUI(pc.getPlayers(), cup.getFaces(), board.getFields());

                    landOnField(curPlayer);

                    guiC.updateGUI(pc.getPlayers(), cup.getFaces(), board.getFields());

                    //Recieve money for passing start
                    checkPassStart(curPlayer, oldLoc);

                    guiC.updateGUI(pc.getPlayers(), cup.getFaces(), board.getFields());

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
                                pc.getPlayer(i).setBankrupt(true);
                                pc.getPlayer(i).setBalance(0);
                                for (int j = 0; j < pc.getPlayer(i).getOwnedFields().length; j++) {
                                    pc.getPlayer(i).removeField(pc.getPlayer(i).getOwnedFields()[j]);
                                }
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
                    if(count==1){
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


    /**
     * Checks if the player has passed start
     * @param curPlayer the player we are checking for
     * @param oldLoc his old location we are comparing to
     * @return the new location
     */
    private int checkPassStart(Player curPlayer, int oldLoc) {
        if(curPlayer.isFree()){
            if(oldLoc > curPlayer.getLocation()){
                curPlayer.receiveMoney(4000);

            }
        }
        oldLoc = curPlayer.getLocation();
        return oldLoc;
    }

    /**
     *Is called when the player is in jail.
     *Contains the logic ensuring the player has all the options for release available.
     *stashedRoll is initially zero, if the player manages to get out by rolling doubles, it will be set to the value of the roll.
     *
     * @param curPlayer The player we run the jail logic on.
     * @param stashedRoll How far we must move the player if he gets out.
     * @return stashedRoll, so we can move the player accordingly to his roll.
     */
    private int jailTurn(Player curPlayer, int stashedRoll) {
        guiC.getOk(Language.currentlyJailed());
        if (guiC.getYesNo(Language.payBail())) {
            curPlayer.payMoney(1000);
            curPlayer.setFree(true);
            return stashedRoll;
        }
        if (curPlayer.getJailCard()>0) {
            if(guiC.getYesNo(Language.useJailCard())){
                curPlayer.removeJailCard(1);
                curPlayer.setFree(true);
                return stashedRoll;
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
            return stashedRoll;
        } else {
            guiC.getOk(Language.jailEscapeFail());
            curPlayer.setJailRollAmount(curPlayer.getJailRollAmount()+1);
            if(curPlayer.getJailRollAmount()==3){
                stashedRoll = cup.getFaceValue();
                guiC.getOk(Language.jailTooLong());
                curPlayer.payMoney(1000);
                curPlayer.setFree(true);
            }
            return stashedRoll;
        }
    }

    /**
     * Determines what fieldcontroller gets called depending on what type of field was landed on.
     * @param landingPlayer the player that we must resolve for
     */
    private void landOnField(Player landingPlayer){
		Field currentField = board.getField(landingPlayer.getLocation());

		if(currentField instanceof ChanceField){
		    int tempLoc = landingPlayer.getLocation();
			guiC.getOk(ccc.resolveChance(landingPlayer, pc.getPlayers(), board.getFields()));
			if(tempLoc != landingPlayer.getLocation()){
			    landOnField(landingPlayer);
            }
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
