package controllers;

import model.*;
import fields.*;

public class MasterController {

	public static final int PLAYER_STARTBALANCE = 30000;
	public static final int GAME_PLAYERS_MAX = 6;
	public static final int GAME_PLAYERS_MIN = 2;
	

	public static void main(String[] args)  {
		int currentturn = 0;
		DiceController cup = new DiceController();
		GUIController guiC = GUIController.getInstance();
		ModelController modC = ModelController.getInstance();
		guiC.initFields();
		Player[] players = modC.makePlayers(guiC.makePlayers());
		while (true) {
			guiC.getOk(Language.roll());
			players[currentturn].move(cup.roll());
			players[currentturn].receiveMoney(500);
			guiC.updateGUI(players,cup.getFaces());

			currentturn = (currentturn+1) %(players.length);
			
			
			
			
			
		}
		
		
		
		//			guiC.upgrade(players[currentturn].getLocation());
		
	}

}
