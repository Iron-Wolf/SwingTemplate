package data;

import java.awt.Color;
import java.util.Observable;

public class Model extends Observable {
    private Color chColor;

    public void setColor(Color c) {
        System.out.println(c);
        this.chColor = c;
        setChanged();
        notifyObservers();
    }

    public Color getColor() {
        return chColor;
    }
}
