package controllers;

import java.awt.Color;

import gui_fields.*;
import gui_main.*;
import model.Language;
import fields.*;

public class GUIController {
	private static GUIController guiController = new GUIController();
	// array der holder GUI felter
	private GUI_Field[] fieldsGUI;
	private GUIController(){initFields();}
	private GUI gui;
	
	public static GUIController getInstance()
	{
		return guiController;	
	}
	
	public GUI_Field[] initFields()
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
				fieldsGUI[i].setTitle(fields[i].getName());
				fieldsGUI[i].setDescription(fields[i].getName());
			break;
			case 2: 
			case 3: 
				fieldsGUI[i] = new GUI_Tax();
				fieldsGUI[i].setTitle(fields[i].getName());
				fieldsGUI[i].setDescription(fields[i].getName());
			break;
			case 4: 
				fieldsGUI[i] = new GUI_Street();
				fieldsGUI[i].setTitle(fields[i].getName());
				fieldsGUI[i].setDescription(fields[i].getName());
			break;
			case 5: 
				fieldsGUI[i] = new GUI_Brewery();
				fieldsGUI[i].setTitle(fields[i].getName());
				fieldsGUI[i].setDescription(fields[i].getName());
			break;
			case 6: 
				fieldsGUI[i] = new GUI_Shipping();
				fieldsGUI[i].setTitle(fields[i].getName());
				fieldsGUI[i].setDescription(fields[i].getName());
			break;
			default: fieldsGUI[i] = new GUI_Start();
			}	
			
			
		}
		
		return fieldsGUI;
		
		
		
	}
	public void startGUI(GUI_Field[] yup) {
		gui = new GUI(yup);
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
}
