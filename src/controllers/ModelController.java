package controllers;

import model.*;

import java.awt.Color;

import fields.*;


public class ModelController {

    private Player[] players;
    private Dice dice = new Dice();

//    private ModelController(){
//    	board = Board.getInstance();
    

    public ModelController()
    {
    }

	public void addmoney(Player player, int money) {
		player.receiveMoney(money);
	}

}
