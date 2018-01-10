package game.controllers.fields.ownable;

import game.model.Language;
import game.model.Player;
import game.model.fields.Field;
import game.model.fields.ownable.BuildableField;

public class BuildableController extends OwnableController{

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
