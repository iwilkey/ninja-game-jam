package com.mundanepixel.dinte.clock;

import com.mundanepixel.dinte.state.State;

public class Clock {
    public static int FPS;
    public Clock() { FPS = 60; }

    long now = System.nanoTime(),
        last = 0, delta = 0;
    short frames = 0;
    public void tick(State state) {
        state.tick();
        last = now;
        now = System.nanoTime();
        delta += (now - last);
        frames++;
        if(delta >= 1000000000) {
            FPS = frames;
            frames = 0; delta = 0;
        }
    }
}
