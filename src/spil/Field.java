package spil;

import java.awt.*;

public abstract class Field {

    protected String name, subText, description;
    protected Color[] color = new Color[2];

    public Field (String newName, String newSubText, String newDescription, Color primary, Color secondary){
        name = newName;
        subText = newSubText;
        description = newDescription;
        color[0] = primary;
        color[1] = secondary;
    }

    public abstract void landOnField();


}
