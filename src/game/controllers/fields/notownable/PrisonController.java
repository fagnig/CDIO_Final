package game.controllers.fields.notownable;

import game.model.Language;
import game.model.Player;
import game.model.fields.Field;
import game.view.GUIController;

public class PrisonController extends NotOwnableController {
    GUIController guiC = GUIController.getInstance();

    public void landOnField(Player curPlayer, Field curField) {
        if(curPlayer.getLocation() != 10){
            guiC.getOk(Language.jailed());
            curPlayer.forceMove(10);
            curPlayer.setFree(false);
        }
    }
}
