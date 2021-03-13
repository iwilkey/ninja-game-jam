package com.mundanepixel.dinte.state;

import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class State {

    private static State currentState;

    public State() { init(); }

    public static void setState(State state) { currentState = state; }
    public static State getCurrentState() { return currentState; }

    public abstract void init();
    public abstract void tick();
    public abstract void render(Batch b);
    public abstract void onGUI(Batch b);
    public abstract void dispose();
}
