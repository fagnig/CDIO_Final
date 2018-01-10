package controllers;

import model.Player;

public class PlayerController {
	
	private Player[] players;
	
	public PlayerController() {
		
	}
	
	public Player[] makePlayers(String[] navne) {
		players = new Player[navne.length];
		for (int i = 0; i < navne.length ; i++) {
			players[i] = new Player(navne[i],MasterController.PLAYER_STARTBALANCE);
		}
		
		return players;

	}
	public Player[] getPlayers() {
		return players;
	}
	
	public Player getPlayer(int number) {
		return players[number];
	}
}
