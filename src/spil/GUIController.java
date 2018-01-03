package spil;

public class GUIController {
	private static GUIController guiController = new GUIController();
	
	private GUIController(){}
	
	public GUIController getInstance()
	{
		return guiController;	
	}
}
