package com.mundanepixel.dinte.entity;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mundanepixel.dinte.InputHandler;
import com.mundanepixel.dinte.assets.Assets;
import com.mundanepixel.dinte.gfx.Animation;

import java.util.ArrayList;

public class Player extends Entity {

    private static final float SPEED = 3.0f;
    boolean isMoving = true;
    ArrayList<Animation> animations;
    Animation currentAnimation;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
        animations = Assets.playerAnimations;
    }

    @Override
    public void tick() {
        control();
        if(isMoving) currentAnimation = animations.get(0);
        currentAnimation.tick();
    }

    private void control() {
        if(InputHandler.moveRightRequest) {
            position.x += SPEED;
            isMoving = true;
        } else if (InputHandler.moveLeftRequest) {
            position.x -= SPEED;
            isMoving = true;
        } // else isMoving = false;
    }

    @Override
    public void render(Batch b) {
        b.draw(currentAnimation.getCurrentFrame(), position.x, position.y,
                position.width, position.height);
    }

    @Override
    public void die() {

    }

}
