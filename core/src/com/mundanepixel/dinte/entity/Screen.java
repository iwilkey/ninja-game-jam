package com.mundanepixel.dinte.entity;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mundanepixel.dinte.assets.Assets;

public class Screen extends Object {

    static final float scale = 0.5f;
    int unitWidth, unitHeight, realSize = (int)(48 * scale);

    public Screen(int x, int y, int width, int height) {
        super(x, y, width * (int)(48 * scale), height * (int)(48 * scale));
        unitHeight = height; unitWidth = width;
    }

    @Override
    public void tick() {

    }

    int posX, posY;
    @Override
    public void render(Batch b) {
        realSize = (int)(48 * scale);
        for(int x = 0; x <= unitWidth; x++) {
            for(int y = 0; y <= unitHeight; y++) {
                posX = (x * realSize) + position.x;
                posY = (((unitHeight - y) * realSize) + position.y);
                if(x == 0 && y == 0) b.draw(Assets.SCREEN_COMPONENTS.get(0), posX, posY, realSize, realSize);
                else if(x == unitWidth && y == 0) b.draw(Assets.SCREEN_COMPONENTS.get(2), posX, posY, realSize, realSize);
                else if(x == 0 && y == unitHeight) b.draw(Assets.SCREEN_COMPONENTS.get(6), posX, posY, realSize, realSize);
                else if(x == unitWidth && y == unitHeight) b.draw(Assets.SCREEN_COMPONENTS.get(8), posX, posY, realSize, realSize);
                else if(x == 0) b.draw(Assets.SCREEN_COMPONENTS.get(3), posX, posY, realSize, realSize);
                else if(x == unitWidth) b.draw(Assets.SCREEN_COMPONENTS.get(5), posX, posY, realSize, realSize);
                else if(y == 0) b.draw(Assets.SCREEN_COMPONENTS.get(1), posX, posY, realSize, realSize);
                else if(y == unitHeight) b.draw(Assets.SCREEN_COMPONENTS.get(7), posX, posY, realSize, realSize);
                else b.draw(Assets.SCREEN_COMPONENTS.get(4), posX, posY, realSize, realSize);
            }
        }
    }

    @Override
    public void die() {

    }

}
