package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import game.controllers.BoardController;
import game.controllers.PlayerController;
import game.model.Player;
import game.model.fields.Field;
import game.model.fields.ownable.BuildableField;
import game.model.fields.ownable.OwnableField;

public class PlayerTest {
	PlayerController pC = new PlayerController();
	BoardController board = new BoardController();
	String[] names = {"a","b","c","bleh"};


	@Test
	
//	tests the makePlayers method
	public void makePlayersTest() {
		pC.makePlayers(names);
		for (int i = 0 ; i < names.length; i++) {
			assertTrue("not the right player",pC.getPlayer(i).getName().equals(names[i]));
		}
	}


	@Test
//	tests the getPlayer and getPlayers method
	public void getPlayerTest() {
		pC.makePlayers(names);
		Player[] players = pC.getPlayers();
		for (int i = 0 ; i < names.length; i++) {
			assertTrue("not the right players",pC.getPlayer(i)==players[i]);
		}
	}

	@Test
//	tests the canPlayerBuild
	public void canPlayerBuildTest() {
		Field[] fields = board.getFields();
		pC.makePlayers(names);
		Player curPlayer = pC.getPlayer(1);
		
//		all Buildablefields should after this loop belong to one player
		for (int i = 0 ; i< 40; i++) {
			if (fields[i] instanceof BuildableField) {
				BuildableField castedField = ((BuildableField) fields[i]);
				castedField.setOwner(curPlayer);
				curPlayer.addField(castedField);
			}

		}
		board.setAllVals(pC.getPlayers());
		
//		this loop goes through all fields, and checks if the player can build on them if its a buildablefield 
		for (int i = 0 ; i< 40; i++) {
			curPlayer.forceMove(i);
			if(fields[i] instanceof BuildableField) {
				assertTrue("should be able to build",pC.canPlayerBuild(curPlayer));
			}
		}
	}

}
