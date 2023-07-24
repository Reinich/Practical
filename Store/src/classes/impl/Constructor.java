package classes.impl;

import classes.Toy;

public class Constructor extends Toy {
    @Override
    public String getType() {
        return "Конструктор";
    }

    public Constructor(String name, int drop) {
        super(name, drop);
    }

    @Override
    public String toString() {
        return String.format("№%d %s %s", getId(), getType(), getName());
    }
}
