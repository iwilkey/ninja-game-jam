package com.mundanepixel.dinte.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mundanepixel.dinte.gfx.Animation;
import com.mundanepixel.dinte.gfx.SpriteSheet;

import java.util.ArrayList;

public class Assets {

    // Static textures
    public static Texture ROOM_BASE, UI_BASE, SIGNAL;

    // Animations
    // Player animations
        // [0][] = Player walk right
    public static ArrayList<Animation> playerAnimations;

    public static void init() {
        initTextures();
        initStatics();
    }

    private static void initStatics() {
        ROOM_BASE = new Texture("textures/room/roomBase.png");
        UI_BASE = new Texture("textures/ui/userInterface.png");
        SIGNAL = new Texture("textures/ui/signal.png");
    }

    private static void initTextures() {
        initAnimations();
    }

    private static void initAnimations() {
        // Player animations
        playerAnimations = new ArrayList<>();
            // Walk right
        ArrayList<TextureRegion> playerWalkRight = new ArrayList<>();
        SpriteSheet playerWalkRightSheet = new SpriteSheet(new Texture(
                "textures/player/walk/walkingRight.png"),
                432, 550);
        for(int i = 0; i < 30; i++)
            playerWalkRight.add(playerWalkRightSheet.crop(i, 0));
        playerAnimations.add(new Animation(playerWalkRight, (short)1));
    }
}
