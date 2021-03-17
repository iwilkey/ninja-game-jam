package com.mundanepixel.dinte.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mundanepixel.dinte.gfx.Animation;
import com.mundanepixel.dinte.gfx.SpriteSheet;

import java.util.ArrayList;

public class Assets {

    // Static text
    public static String[] ROOM_DIALOG = new String[] {
            "Can you solve my code? No?\nWell, fuck you then. Stupid \nasshole!",
            ""
    };

    // Static textures
    // Big Textures
    public static Texture ROOM_BASE, UI_BASE, SIGNAL,
        DOOR_LEFT, DOOR_RIGHT;
    // Components

    // Screen
        // 0 - Upper left hand corner
        // 1 - Upper center
        // 2 - Upper right hand corner
        // 3 - Center left side
        // 4 - Center
        // 5 - Center right side
        // 6 - Lower left hand corner
        // 7 - Lower center
        // 8 - Lower right hand corner
    public static ArrayList<TextureRegion> SCREEN_COMPONENTS;

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
        DOOR_LEFT = new Texture("textures/room/objects/doorLeft.png");
        DOOR_RIGHT = new Texture("textures/room/objects/doorRight.png");

        // Components

        // Screen
        SCREEN_COMPONENTS = new ArrayList<>();
        SpriteSheet screenSheet = new SpriteSheet(
                new Texture("textures/ui/screen.png"),
                48, 48);
        for(int y = 0; y <= 2; y++)
            for(int x = 0; x <= 2; x++)
                SCREEN_COMPONENTS.add(screenSheet.crop(x, y));
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
