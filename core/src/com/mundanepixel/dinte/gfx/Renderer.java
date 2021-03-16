package com.mundanepixel.dinte.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mundanepixel.dinte.state.State;

public class Renderer {

    public static int DEFAULT_WIDTH, DEFAULT_HEIGHT;
    public static float SCALEX, SCALEY;
    static SpriteBatch gfxBatch,
        guiBatch;

    public Renderer() {
        DEFAULT_WIDTH = Gdx.graphics.getWidth();
        DEFAULT_HEIGHT = Gdx.graphics.getHeight();
        gfxBatch = new SpriteBatch();
        guiBatch = new SpriteBatch();
    }

    public void render(State state) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gfxBatch.begin();
        state.render(gfxBatch);
        gfxBatch.end();

        guiBatch.begin();
        state.onGUI(guiBatch);
        guiBatch.end();
    }

    public void resize(int width, int height) {
        SCALEX = (width / (float)DEFAULT_WIDTH);
        SCALEY = (height / (float)DEFAULT_HEIGHT);
    }

    public void dispose() {
        gfxBatch.dispose();
    }



}
