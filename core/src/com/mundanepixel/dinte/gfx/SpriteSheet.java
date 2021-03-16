package com.mundanepixel.dinte.gfx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSheet {
    public static int SLOT_WIDTH, SLOT_HEIGHT;
    public Texture sheet;

    public SpriteSheet(Texture sheet, int slotWidth, int slotHeight) {
        this.sheet = sheet;
        SLOT_WIDTH = slotWidth;
        SLOT_HEIGHT = slotHeight;
    }

    public TextureRegion crop(int x, int y) {
        return new TextureRegion(sheet, x * SLOT_WIDTH, y * SLOT_HEIGHT,
                SLOT_WIDTH, SLOT_HEIGHT);
    }
}
