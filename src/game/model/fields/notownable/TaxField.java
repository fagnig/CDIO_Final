package game.model.fields.notownable;

import game.model.fields.Field;

import java.awt.*;

public abstract class TaxField extends Field {
    public TaxField(String newName, Color primary, Color secondary){
        super(newName, primary, secondary);
    }
}
