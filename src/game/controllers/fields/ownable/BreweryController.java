package game.controllers.fields.ownable;

import game.model.Language;
import game.model.Player;
import game.model.fields.Field;
import game.model.fields.ownable.BreweryField;

public class BreweryController extends OwnableController {

    public void landOnField(Player curPlayer, Field curField){
        BreweryField castedField = ((BreweryField) curField);
        if(!castedField.isMortgaged()) {
            if (castedField.getOwner() == null) {
                if (guiC.getYesNo(Language.wantToBuy(castedField))) {
                    castedField.setOwner(curPlayer);
                    curPlayer.addField(castedField);
                    curPlayer.payMoney(castedField.getPrice());
                }
            } else {
                int rent = castedField.getRent()[0] * 100 * castedField.getAmountOwned();
                guiC.getOk(curPlayer.getName() + Language.payRent() + castedField.getOwner().getName() + " " + rent);
                curPlayer.payMoney(rent);
                castedField.getOwner().receiveMoney(rent);
            }
        } else {
            guiC.getOk(Language.fieldMortgaged());
        }
    }
}
