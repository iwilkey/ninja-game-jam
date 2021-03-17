package com.mundanepixel.dinte.entity;

import com.badlogic.gdx.graphics.g2d.Batch;

import com.mundanepixel.dinte.InputHandler;
import com.mundanepixel.dinte.assets.Assets;
import com.mundanepixel.dinte.gfx.Animation;

import java.util.ArrayList;

public class Player extends Entity {

    private static final float SPEED = 3.0f;
    boolean isMoving = false, lookingRight = true;
    ArrayList<Animation> animations;
    Animation currentAnimation;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
        animations = Assets.playerAnimations;
    }

    @Override
    public void tick() {
        control();
        if(isMoving && lookingRight) currentAnimation = animations.get(0);
        if(isMoving && !lookingRight) currentAnimation = animations.get(1);
        if(!isMoving && lookingRight) currentAnimation = animations.get(2);
        if(!isMoving && !lookingRight) currentAnimation = animations.get(3);
        currentAnimation.tick();
    }

    private void control() {
        if(InputHandler.moveRightRequest) {
            lookingRight = true;
            position.x += SPEED;
            isMoving = true;
        } else if (InputHandler.moveLeftRequest) {
            lookingRight = false;
            position.x -= SPEED;
            isMoving = true;
        } else isMoving = false;
    }

    @Override
    public void render(Batch b) {
        if(!isMoving)
            b.draw(currentAnimation.getCurrentFrame(), position.x, position.y,
                    position.width, position.height);
        else b.draw(currentAnimation.getCurrentFrame(), position.x - 12, position.y,
                position.width * 1.23f, position.height * 1.23f);
    }

    @Override
    public void die() {

    }

}
