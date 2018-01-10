package game.controllers.field;

import game.model.Player;
import game.model.fields.Field;

public abstract class FieldController {

    public abstract void landOnField(Player curPlayer, Field curField);
}
