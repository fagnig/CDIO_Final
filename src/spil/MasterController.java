package spil;

public class MasterController {

    public static int PLAYER_STARTBALANCE = 30000;
    public static int GAME_PLAYERS_MAX = 6;
    public static int GAME_PLAYERS_MIN = 2;

	public static void main(String[] args) {

		GUIController guiC = GUIController.getInstance();
		guiC.initFields();
		guiC.showMessage("hej");
	}

}
