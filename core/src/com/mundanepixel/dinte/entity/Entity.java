package com.mundanepixel.dinte.entity;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.*;

public abstract class Entity {
    public Rectangle position;
    public TextureRegion currentSprite;

    public Entity(int x, int y, int width, int height) {
        position = new Rectangle(x, y, width, height);
    }

    public abstract void tick();
    public abstract void render(Batch b);
    public abstract void die();
}
