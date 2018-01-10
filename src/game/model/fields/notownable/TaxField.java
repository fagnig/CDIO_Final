package game.model.fields.notownable;

import java.awt.*;

public abstract class TaxField extends NotOwnable {
    public TaxField(String newName, Color primary, Color secondary){
        super(newName, primary, secondary);
    }
}
