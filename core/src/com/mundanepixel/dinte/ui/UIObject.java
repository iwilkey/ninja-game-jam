package com.mundanepixel.dinte.ui;

import com.badlogic.gdx.graphics.g2d.Batch;

import java.awt.*;

public abstract class UIObject {
    public final Rectangle DEFAULT_COLLIDER;
    public UIObject() {
        DEFAULT_COLLIDER = new Rectangle();
    }
    public UIObject(int x, int y, int width, int height) {
        DEFAULT_COLLIDER = new Rectangle(x, y, width, height);
    }
    public abstract void tick();
    public abstract void render(Batch b);
    public void onResize(int width, int height) {}
}
