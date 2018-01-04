package spil;

import java.awt.*;

public abstract class Field {

    protected String name, subText, description;
    protected Color[] color = new Color[2];
    protected int type;

    public Field (String newName, String newSubText, String newDescription, Color primary, Color secondary, int newType){
        name = newName;
        subText = newSubText;
        description = newDescription;
        color[0] = primary;
        color[1] = secondary;
        type = newType;
    }

    public abstract void landOnField(Player landingPlayer);

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getSubText() {
        return subText;
    }

    public String getDescription() {
        return description;
    }

    public Color[] getColor() {
        return color;
    }

    public String getPriceString(){
        return "";
    }

}
