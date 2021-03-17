package com.mundanepixel.dinte.entity;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mundanepixel.dinte.assets.Assets;
import com.mundanepixel.dinte.state.GameState;
import com.mundanepixel.dinte.ui.Container;
import com.mundanepixel.dinte.ui.Text;

public class Screen extends Object {

    static final float scale = 0.5f;
    int unitWidth, unitHeight, realSize = (int)(48 * scale);

    public Container screenContainer;

    public Screen(int x, int y, int width, int height) {
        super(x, y, width * (int)(48 * scale), height * (int)(48 * scale));
        unitHeight = height; unitWidth = width;
        screenContainer = new Container(x, y, position.width + 24,  position.height + 24);
    }

    public Text addText(Text text) {
        screenContainer.addText(text);
        text.setColor(GameState.tC);
        return text;
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
        screenContainer.render(b);
    }

    @Override
    public void die() {

    }

}
