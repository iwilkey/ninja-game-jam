package com.mundanepixel.dinte.level;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mundanepixel.dinte.assets.Assets;
import com.mundanepixel.dinte.entity.EntityHandler;
import com.mundanepixel.dinte.entity.Player;
import com.mundanepixel.dinte.gfx.Renderer;
import com.mundanepixel.dinte.level.puzzle.Puzzle;

public class Room {
    protected int number;
    protected EntityHandler entityHandler;
    protected Puzzle puzzle;

    Texture base;

    public Room(int number, Puzzle puzzle) {
        this.number = number;
        this.puzzle = puzzle;
        base = Assets.ROOM_BASE;
        entityHandler = new EntityHandler(this);
        entityHandler.addEntity(new Player(200, 260,
                (int)(0.2f * 432), (int)(0.2f * 550)));
    }

    public void tick() {
        entityHandler.tick();
        puzzle.tick();
    }

    public void render(Batch b) {
        b.draw(base, 0,0, Renderer.DEFAULT_WIDTH, Renderer.DEFAULT_HEIGHT);
        entityHandler.render(b);
        puzzle.render(b);
    }

    public void onGUI(Batch b) {
        puzzle.onGUI(b);
    }
}
