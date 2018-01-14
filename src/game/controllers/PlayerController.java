package game.controllers;

import game.MasterController;
import game.model.Player;
import game.model.fields.ownable.BuildableField;

public class PlayerController {
	
	private Player[] players;
	
	public PlayerController() {
		
	}

	/**
	 * Initialises
	 * @param names
	 */
	public void makePlayers(String[] names) {
		players = new Player[names.length];
		for (int i = 0; i < names.length ; i++) {
			players[i] = new Player(names[i], MasterController.PLAYER_STARTBALANCE);
		}

	}
	public Player[] getPlayers() {
		return players;
	}
	
	public Player getPlayer(int number) {
		return players[number];
	}

	public boolean canPlayerBuild(Player curPlayer) {
		for(int i = 0; i<curPlayer.getOwnedFields().length;i++){
			if(curPlayer.getOwnedFields()[i] instanceof BuildableField){
				if(((BuildableField) curPlayer.getOwnedFields()[i]).getBuildable()){
					return true;
				}
			}
		}
		return false;
	}
}
