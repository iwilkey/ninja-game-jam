package com.mundanepixel.dinte.level;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mundanepixel.dinte.level.puzzle.Puzzle;

public class Room {
    protected int number;
    protected Puzzle puzzle;
    public Room(int number, Puzzle puzzle) {
        this.number = number;
        this.puzzle = puzzle;
    }

    public void tick() {
        puzzle.tick();
    }

    public void render(Batch b) {
        puzzle.render(b);
    }

    public void onGUI(Batch b) {
        puzzle.onGUI(b);
    }
}
