package com.mundanepixel.dinte.entity;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mundanepixel.dinte.assets.Assets;

public class Door extends Object {
    // Pictures are 160 x 420

    boolean isLeft, isOpen;
    public Door(boolean isLeft) {
        super(0,243,120 / 2,420 / 2);
        this.isOpen = true;
        this.isLeft = isLeft;
        if(isLeft) position.x = 120;
        else position.x = 800;
        close();
    }

    @Override
    public void tick() {

    }

    private void close() {

    }

    @Override
    public void render(Batch b) {
        if(isLeft) b.draw(Assets.DOOR_LEFT, position.x, position.y,
                position.width, position.height);
        else b.draw(Assets.DOOR_RIGHT, position.x, position.y,
                position.width, position.height);

    }

    @Override
    public void die() {

    }
}
