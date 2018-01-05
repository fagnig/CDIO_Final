package controllers;

import model.*;
import fields.*;


public class ModelController {
    private static ModelController modelController = new ModelController();
//    private Player[] players;
      private Board board;
//    private Dice dice;

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
}
