package game.controllers.field.ownable;

import game.model.Language;
import game.model.Player;
import game.model.fields.Field;
import game.model.fields.ownable.BuildableField;
import game.view.GUIController;

public class BuildableController extends OwnableController{
    private GUIController guiC = GUIController.getInstance();

    public void landOnField(Player curPlayer, Field curField) {
        BuildableField castedField = ((BuildableField) curField);
        if (castedField.getOwner() == null){
            if(guiC.getYesNo(Language.wantToBuy(castedField))){
                castedField.setOwner(curPlayer);
                curPlayer.payMoney(castedField.getPrice());
            }
        } else {

            int rent = castedField.getRent()[castedField.getBuildStatus()]*castedField.getAmountOwned();
            guiC.getOk(curPlayer.getName()  + Language.payRent() + castedField.getOwner().getName()+ " "+ rent);
            curPlayer.payMoney(rent);
            castedField.getOwner().receiveMoney(rent);

        }
    }
}
