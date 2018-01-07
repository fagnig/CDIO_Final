package controllers;

import model.*;

import java.awt.Color;

import fields.*;


public class ModelController {
    private static ModelController modelController = new ModelController();
    private Player[] players;
    private Board board;
    private Dice dice = new Dice();

    private ModelController(){
    	board = new Board();
    }

    public static ModelController getInstance()
    {
        return modelController;
    }

	public Field[] getFields() {
		return board.getFields();
	}
	public Player[] makePlayers(String[] navne) {
		players = new Player[navne.length];
		for (int i = 0; i<navne.length;i++) {
			players[i] = new Player(navne[i]);
		}
		
		return players;
	}
	public Player[] getPlayers() {
		return players;
	}
	public void addmoney(Player player, int money) {
		player.receiveMoney(money);
	}
	public int roll() {
		dice.roll();
		return dice.getFaceValue();	
	}
	public int[] getFaces() {
		return dice.getFaces();
	}
}
