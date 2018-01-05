package spil;

import java.awt.Color;

import gui_fields.*;
import gui_main.*;

public class GUIController {
	private static final GUIController guiController = new GUIController();
	private GUI_Field[] fieldsGUI;
	private GUIController(){}
	private GUI gui;
	
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
		
		fieldsGUI = new GUI_Field[40];
		fieldsGUI[0] = new GUI_Start();
		for (int i = 1; i< 40; i++) {
			fieldsGUI[i] = new GUI_Street();
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
}
