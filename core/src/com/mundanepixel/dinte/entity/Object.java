package com.mundanepixel.dinte.entity;

public abstract class Object extends Entity {
    public boolean isInteractable = true;
    public Object(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
