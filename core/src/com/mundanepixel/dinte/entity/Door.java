package com.mundanepixel.dinte.entity;

import com.badlogic.gdx.graphics.g2d.Batch;

import com.mundanepixel.dinte.InputHandler;
import com.mundanepixel.dinte.assets.Assets;

public class Door extends Object {
    // Pictures are 160 x 420

    boolean isLeft, isOpen, isClosing = true, isOpening = false;
    final int DOOR_SPEED = 10;
    public Door(boolean isLeft) {
        super(0,243,120 / 2,420 / 2);
        this.isOpen = true;
        position.y = 380;
        this.isLeft = isLeft;
        if(isLeft) position.x = 120;
        else position.x = 800;
        close();
    }

    @Override
    public void tick() {
        if(isClosing) close();
        if(isOpening) open();
        if(InputHandler.leftMouseButtonDown)
            open();
        if(InputHandler.rightMouseButtonDown)
            close();
    }

    public void close() {
        isClosing = true;
        isOpening = false;
        if(position.y >= 243) position.y -= DOOR_SPEED;
        else isClosing = false;
    }

    public void open() {
        isOpening = true;
        isClosing = false;
        if(position.y < 380) position.y += DOOR_SPEED;
        else isOpening = false;
    }

    @Override
    public void render(Batch b) {
        if(isLeft) b.draw(Assets.DOOR_LEFT, position.x, position.y,
                position.width, position.height);
        else b.draw(Assets.DOOR_RIGHT, position.x, position.y,
                position.width, position.height);

    }

    @Override
    public void die() {}
}
