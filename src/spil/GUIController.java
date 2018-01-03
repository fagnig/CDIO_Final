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
		//ModelController mC = modelController.getInstance();
		//Field[] fields = mC.getBoard().getFields();
		//for(int i=0; i>=fields.length(), i++){
		//	if fields[i].getType() == 0{
		//		fieldsGUI[i] = new GUI_Start(fields[i].getName(), fields[i].getSubText(), fields[i].getDescription(), fields[i].getPrimaryColor(), fields[i].getSecondaryColor());
		//	}
		//}

		//gui = new GUI(fieldsGUI);
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
