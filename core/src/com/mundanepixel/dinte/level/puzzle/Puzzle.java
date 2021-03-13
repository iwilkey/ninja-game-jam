package com.mundanepixel.dinte.level.puzzle;

import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class Puzzle {
    public Puzzle() {}
    public abstract void tick();
    public abstract void render(Batch b);
    public abstract void onGUI(Batch b);
}
