package game.view;

import java.awt.Color;

import game.MasterController;
import game.model.fields.Field;
import game.model.fields.ownable.OwnableField;
import gui_fields.*;
import gui_main.*;
import game.model.*;

public class GUIController {
	// array der holder GUI felter
	private GUI_Field[] fieldsGUI;
	private GUI gui;
	private GUI_Player[] players;
	
	private GUIController(){}

	private static GUIController guiC = new GUIController();

	public static GUIController getInstance(){
	    return guiC;
    }


	public void initFields(game.model.fields.Field[] fields)
	{

		fieldsGUI = new GUI_Field[40];
		fieldsGUI[0] = new GUI_Start();
		int type = 0;
		for (int i = 0; i<40 ; i++) {
			type = fields[i].getType();
			switch (type) {
			case 1:
				fieldsGUI[i] = new GUI_Chance();
				
			break;
			case 2:
			case 3: 
				fieldsGUI[i] = new GUI_Tax();
			break;
			case 4: 
				fieldsGUI[i] = new GUI_Street();
		
			break;
			case 5: 
				fieldsGUI[i] = new GUI_Brewery();
		
			break;
			case 6: 
				fieldsGUI[i] = new GUI_Shipping();
	
			break;
			case 7:
				fieldsGUI[i] = new GUI_Refuge();
				
			break;
			case 8: fieldsGUI[i] = new GUI_Jail();
			
			break;
			
			default: fieldsGUI[i] = new GUI_Start();
			}
			fieldsGUI[i].setTitle(fields[i].getName());
			fieldsGUI[i].setSubText(fields[i].getSubText());
			fieldsGUI[i].setDescription(fields[i].getDescription());
			fieldsGUI[i].setBackGroundColor(fields[i].getColor()[0]);
			fieldsGUI[i].setForeGroundColor(fields[i].getColor()[1]);
			if(i==10) {
				fieldsGUI[i].setSubText("På besøg");
				fieldsGUI[i].setDescription("De sidder i fængsel. slå 2 ens, betal kr 1000 eller anvend dit løsladeskort hvis haves. Hvis der slås 2 ens rykker de det antal felter frem.");
			}
			if(i==20) {
				fieldsGUI[i].setSubText("Parkering");
				fieldsGUI[i].setDescription("GØR NOGET VED DINE DRØMME!");
			}
			
		}
		
		gui = new GUI(fieldsGUI);
		
		
		
	}
	
	public void showMessage(String message) 
	{
		gui.showMessage(message);
	}
	
	public void showChanceCard(String message) 
	{
		gui.displayChanceCard(message);
	}
	
	public void updateDice(int[] t) 
	{
		gui.setDice(t[0], t[1]);
	}
	
	public boolean getYesNo(String message) 
	{
		return (gui.getUserLeftButtonPressed(message, Language.yes(), Language.no()));
	}
	
	public int getInteger(String message, int[] limits) 
	{
		return gui.getUserInteger(message, limits[0], limits[1]);
	}
	public int getInteger(String message) 
	{
		return gui.getUserInteger(message);
	}
	
	public String getString(String message) 
	{
		return gui.getUserString(message);
	}
	public String getOk(String message) {
		return gui.getUserButtonPressed(message,Language.okay());
	}
	
	public String[] makePlayers() {
		while (true) {
		int numOfPlayers = gui.getUserInteger(Language.numberOfPlayers(), MasterController.GAME_PLAYERS_MIN, MasterController.GAME_PLAYERS_MAX);
		if (numOfPlayers >= MasterController.GAME_PLAYERS_MIN && numOfPlayers <= MasterController.GAME_PLAYERS_MAX ) {
			players = new GUI_Player[numOfPlayers];
			String[] playerNames = new String[numOfPlayers];
			for (int i = 0; i<numOfPlayers; i++) {
				while (true) {
				playerNames[i] = gui.getUserString(Language.player()+ " " + (i+1)+ " " + Language.name());
				if (playerNames[i].equals(" ")|| playerNames[i].length() == 0) {
					getOk(Language.realName());
				}
				else break;
				}
				String b = gui.getUserSelection(Language.pickColor(),Language.red(), Language.blue(),Language.gray(),Language.yellow(),Language.cyan(),Language.pink());
				GUI_Car a = new GUI_Car();
				if (b.equals(Language.red()))
					a.setPrimaryColor(Color.red);
				if (b.equals(Language.blue()))
					a.setPrimaryColor(Color.blue);
				if (b.equals(Language.gray()))
					a.setPrimaryColor(Color.black);
				if (b.equals(Language.yellow()))
					a.setPrimaryColor(Color.yellow);
				if (b.equals(Language.cyan()))
					a.setPrimaryColor(Color.cyan);
				if (b.equals(Language.pink()))
					a.setPrimaryColor(Color.pink);
				a.setSecondaryColor(Color.gray);
				
				players[i] = new GUI_Player(playerNames[i], MasterController.PLAYER_STARTBALANCE,a);
				gui.addPlayer(players[i]);
			}
			
				
			return playerNames;
		}
		else gui.getUserButtonPressed(Language.invalidPlayers(),Language.okay());
		}
	}
	
	public void setBuildStatus(int location, int level) {
		GUI_Street a = (GUI_Street) fieldsGUI[location];
		level = Math.min(5,Math.max(0,level));
		if (level < 5){
		    a.setHouses(level);
            a.setHotel(false);
		} else {
		    a.setHouses(0);
		    a.setHotel(true);
        }
	}
	
	public void updateGUI(Player[] player, int[] faces, Field[] fields) {
			for (int i = 0; i < fieldsGUI.length; i++) {
				fieldsGUI[i].removeAllCars();
			}
			for (int i = 0; i < player.length; i++) {
				fieldsGUI[player[i].getLocation()].setCar(players[i], true);
				players[i].setBalance(player[i].getBalance());
                for (int j = 0; j < fields.length; j++){
                    if(fieldsGUI[j] instanceof GUI_Street){
                        if(((OwnableField) fields[j]).getOwner() != null && ((OwnableField) fields[j]).getOwner().equals(player[i])) {
                            ((GUI_Street) fieldsGUI[j]).setBorder(players[i].getPrimaryColor());
                        }
                    }
                }
			}
			gui.setDice(faces[0], faces[1]);

		}

	public boolean getTaxChoice(String message)
	{
		return (gui.getUserLeftButtonPressed(message, Language.scaling(), Language.flat()));
	}

}
