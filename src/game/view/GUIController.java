package game.view;

import java.awt.Color;

import game.MasterController;
import game.model.fields.Field;
import game.model.fields.ownable.BuildableField;
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
				fieldsGUI[i].setSubText(Language.visit());
				fieldsGUI[i].setDescription(Language.jailDesc());
			}
			if(i==20) {
				fieldsGUI[i].setSubText(Language.parking());
				fieldsGUI[i].setDescription(Language.parkingDesc());
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
		int numOfPlayers = getInteger(Language.numberOfPlayers(), new int [] {MasterController.GAME_PLAYERS_MIN, MasterController.GAME_PLAYERS_MAX});
		if (numOfPlayers >= MasterController.GAME_PLAYERS_MIN && numOfPlayers <= MasterController.GAME_PLAYERS_MAX ) {
			players = new GUI_Player[numOfPlayers];
			String[] playerNames = new String[numOfPlayers];
			for (int i = 0; i<numOfPlayers; i++) {
				while (true) {
				playerNames[i] = getString(Language.player()+ " " + (i+1)+ " " + Language.name());
				if (playerNames[i].equals(" ")|| playerNames[i].length() == 0) {
					getOk(Language.realName());
				}
				else break;
				}
				String b = chooseColor(Language.pickColor(), new String [] {Language.red(), Language.blue(),Language.gray(),Language.yellow(),Language.cyan(),Language.pink()});
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
		else {
            gui.getUserButtonPressed(Language.invalidPlayers(), Language.okay());
        }
		}
	}
	
	public void setBuildStatus(int location, int level) {
		GUI_Street a = (GUI_Street) fieldsGUI[location];

		if (level < 5){
		    a.setHouses(level);
		} else {
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
                        setBuildStatus(j,((BuildableField) fields[j]).getBuildStatus());
                        if(((BuildableField) fields[j]).getOwner() != null && ((BuildableField) fields[j]).getOwner().equals(player[i])) {
                            if(!((BuildableField) fields[j]).isMortgaged()) {
                                ((GUI_Street) fieldsGUI[j]).setBorder(players[i].getPrimaryColor());
                            } else {
                                ((GUI_Street) fieldsGUI[j]).setBorder(players[i].getPrimaryColor(), Color.BLACK);
                            }
                        }
                    }
                }
			}
			gui.setDice(faces[0], faces[1]);

		}

	public boolean getTaxChoice(String message) {
		return (gui.getUserLeftButtonPressed(message, Language.scaling(), Language.flat()));
	}

	public OwnableField chooseFieldMortgage(String message, OwnableField[] fields){
        int index = 0;

	    for(int i = 0; i < fields.length;i++){
	        if(!fields[i].isMortgaged()){
	            index++;
            }
        }

        OwnableField[] tempFields = new OwnableField[index];
        String[] tempNames = new String[index];
        int counter = 0;
        for(int i = 0; i < fields.length;i++){
            if(!fields[i].isMortgaged()){
                tempFields[counter] = fields[i];
                tempNames[counter] = fields[i].getName() + " - " + fields[i].getPrice() + Language.getCurrency();
                counter++;
            }
        }


	    String result = gui.getUserSelection(message, tempNames);

	    for(int i = 0; i<tempNames.length; i++){
	        if(tempNames[i].equals(result)){
	            return tempFields[i];
            }
        }

        //failsafe
        return new BuildableField("",Color.BLACK,Color.BLACK,0,new int[] {},0,0);
    }

    public BuildableField chooseFieldBuild(String message, BuildableField[] ownedFields){

        String[] tempNames = new String[ownedFields.length];

        for(int i = 0; i<ownedFields.length;i++){
            tempNames[i] = ownedFields[i].getName();
        }

        String result = gui.getUserSelection(message, tempNames);

        for(int i = 0; i<tempNames.length; i++){
            if(tempNames[i].equals(result)){
                return ownedFields[i];
            }
        }


	    return new BuildableField("",Color.BLACK,Color.BLACK,0,new int[] {},0,0);
    }

    public String chooseColor(String message, String[] colors){

	    return gui.getUserSelection(message, colors);
    }
}
