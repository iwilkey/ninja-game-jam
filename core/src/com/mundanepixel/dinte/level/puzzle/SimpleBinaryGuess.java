package com.mundanepixel.dinte.level.puzzle;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mundanepixel.dinte.assets.Assets;
import com.mundanepixel.dinte.entity.EntityHandler;
import com.mundanepixel.dinte.gfx.Renderer;

// Level 1
public class SimpleBinaryGuess extends Puzzle {

    public Texture BASE, DEC;
    @Override
    public void init(EntityHandler handler) {
        BASE = Assets.ROOM_ONE_BASE;
        DEC = Assets.ROOM_ONE_DEC;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Batch b) {
        b.draw(BASE, 0,0, Renderer.DEFAULT_WIDTH, Renderer.DEFAULT_HEIGHT);
        b.draw(DEC, 0,0, Renderer.DEFAULT_WIDTH, Renderer.DEFAULT_HEIGHT);
    }

    @Override
    public void onGUI(Batch b) {

    }
}
