package controllers;

import model.*;
import fields.*;

public class MasterController {
	// important numbers for the game
	public static final int PLAYER_STARTBALANCE = 30000;
	public static final int GAME_PLAYERS_MAX = 6;
	public static final int GAME_PLAYERS_MIN = 2;
	
	// instantiation of controllers
	DiceController cup = new DiceController();
	GUIController guiC = new GUIController();
	BoardController board = new BoardController();
	PlayerController pc = new PlayerController();
	Player[] players;
	int currentturn = 0;
	
	
	
	private void init() {
		guiC.initFields(board.getFields());
		players = pc.makePlayers(guiC.makePlayers());
		
		
	}
	
	public void go() {
		//gameLoop
		while (true) {
			guiC.getOk(Language.roll());
			players[currentturn].move(cup.roll());
			players[currentturn].receiveMoney(500);
			guiC.updateGUI(players,cup.getFaces());

			currentturn = (currentturn+1) %(players.length);
			
			
			
			
			
		}
	}
		

	
	
	
	
	
	public static void main(String[] args)  {
		MasterController mc = new MasterController();
		mc.init();
		mc.go();
	}
}
