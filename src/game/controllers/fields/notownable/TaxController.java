package game.controllers.fields.notownable;

import game.model.Language;
import game.model.Player;
import game.model.fields.Field;
import game.view.GUIController;

public class TaxController extends NotOwnableController{
    GUIController guiC = GUIController.getInstance();

    public void landOnField(Player curPlayer, Field curField) {
        if(curPlayer.getLocation() != 4){
            guiC.getOk(Language.payTax());
            curPlayer.payMoney(4000);
        } else {
            if(guiC.getTaxChoice(Language.taxType())){
                curPlayer.payMoney(curPlayer.getTotalValue()/10);
            }
            else{
                curPlayer.payMoney(4000);
            }
        }
    }
}
