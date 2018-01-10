package game.model.fields.notownable;

import java.awt.*;

public class TaxField extends NotOwnable {
    public TaxField(String newName, Color primary, Color secondary){
        super(newName, primary, secondary);
        type = 2;
    }

}
