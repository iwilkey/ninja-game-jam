package com.mundanepixel.dinte.gfx;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class Animation {
    private final ArrayList<TextureRegion> frames;
    public short speed;
    private byte index;

    public Animation(ArrayList<TextureRegion> frames, short speed) {
        this.frames = frames;
        this.speed = speed;
    }

    short timer;
    public void tick() {
        if(timer < speed)
            timer++;
        else {
            timer = 0;
            nextFrame();
        }
    }

    private void nextFrame() {
        index++;
        if(index >= frames.size())
            index = 0;
    }

    public TextureRegion getCurrentFrame() {
        return frames.get(index);
    }
}
