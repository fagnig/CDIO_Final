package controllers;

import java.awt.Color;

import gui_fields.*;
import gui_main.*;
import model.*;
import fields.*;

public class GUIController {
	private static GUIController guiController = new GUIController();
	// array der holder GUI felter
	private GUI_Field[] fieldsGUI;
	private GUIController(){}
	private GUI gui;
	private GUI_Player[] players;
	
	public static GUIController getInstance()
	{
		return guiController;	
	}
	
	public void initFields()
	{
//		//0 = Start
//		//1 = Street
//		//2 = Chance
//		//3 = Brewery
//		//4 = Jail
//		//5 = Shipping
//		//6 = Refuge
//
//		ModelController mC = ModelController.getInstance();
//		Field[] fields = mC.getBoard().getFields();
//		for(int i=0; i>=fields.length; i++){
//			if (fields[i].getType() == 0){
//				fieldsGUI[i] = new GUI_Start(fields[i].getName(), fields[i].getSubText(), fields[i].getDescription(), fields[i].getColor()[0], fields[i].getColor()[1]);
//			}
//			if (fields[i].getType() == 1){
//				fieldsGUI[i] = new GUI_Street(fields[i].getName(), fields[i].getSubText(), fields[i].getDescription(), fields[i].getPriceString(),fields[i].getColor()[0], fields[i].getColor()[1]);
//			}
//		}
		
//		eksempel
//		
		fieldsGUI = new GUI_Field[40];
		ModelController mC = ModelController.getInstance();
		Field[] fields = mC.getFields();
		fieldsGUI[0] = new GUI_Start();
		int type = 0;
		for (int i = 1; i<40 ; i++) {
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
			default: fieldsGUI[i] = new GUI_Start();
			}
			fieldsGUI[i].setTitle(fields[i].getName());
			fieldsGUI[i].setDescription(fields[i].getName());
			fieldsGUI[i].setBackGroundColor(fields[i].getColor()[0]);
			
			
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
		return gui.getUserButtonPressed(message,"okay");
	}
	
	public String[] makePlayers() {
		while (true) {
		int numOfPlayers = gui.getUserInteger("hvor mange spillere er i?", MasterController.GAME_PLAYERS_MIN, MasterController.GAME_PLAYERS_MAX);
		if (numOfPlayers >= MasterController.GAME_PLAYERS_MIN && numOfPlayers < MasterController.GAME_PLAYERS_MAX ) {
			players = new GUI_Player[numOfPlayers];
			String[] playerNames = new String[numOfPlayers];
			for (int i = 0; i<numOfPlayers; i++) {
				while (true) {
				playerNames[i] = gui.getUserString("spiller " + (i+1)+ " hedder hvad?");
				if (playerNames[i].equals(" ")|| playerNames[i].length() == 0) {
					getOk("indtast et rigtigt navn");
				}
				else break;
				}
				String b = gui.getUserSelection("vælg en farve mester","red", "blue","black","yellow","cyan","pink");
				GUI_Car a = new GUI_Car();
				if (b.equals("red"))
					a.setPrimaryColor(Color.red);
				if (b.equals("blue"))
					a.setPrimaryColor(Color.blue);
				if (b.equals("black"))
					a.setPrimaryColor(Color.black);
				if (b.equals("yellow"))
					a.setPrimaryColor(Color.yellow);
				if (b.equals("cyan"))
					a.setPrimaryColor(Color.cyan);
				if (b.equals("pink"))
					a.setPrimaryColor(Color.pink);
				a.setSecondaryColor(Color.black);
				
				players[i] = new GUI_Player(playerNames[i],MasterController.PLAYER_STARTBALANCE,a);
				gui.addPlayer(players[i]);
			}
			
				
			return playerNames;
		}
		else gui.getUserButtonPressed("ugyldigt antal spillere, prøv igen","okay");
		}
	}
	
	public void upgrade(int antal) {
		GUI_Street a = (GUI_Street) fieldsGUI[11];
		if (antal <4)
		a.setHouses(antal);	
		else a.setHotel(true);
	}
	
	public void updateGUI(Player[] player, int[] faces) {
			for (int i = 0; i < fieldsGUI.length; i++) {
				fieldsGUI[i].removeAllCars();
			}
			for (int i = 0; i < player.length; i++) {
				fieldsGUI[player[i].getLocation()].setCar(players[i], true);
				players[i].setBalance(player[i].getBalance());
			}
			gui.setDice(faces[0], faces[1]);
			
		}
	}


	

