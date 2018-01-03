package spil;

public class GUIController {
	private static final GUIController guiController = new GUIController();
	
	private GUIController(){}
	
	public GUIController getInstance()
	{
		return guiController;	
	}
}
