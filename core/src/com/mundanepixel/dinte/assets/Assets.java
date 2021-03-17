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
    // Levels
        // Room one
        public static Texture ROOM_ONE_BASE, ROOM_ONE_DEC;
        public static Animation ROOM_ONE_ANIMATION;
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
        // [0][] = Player walk right (216 275)
        // [1][] = Player walk left
        // [2][] = Player idle right (178 222)
        // [3][] = Player idle left
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

        // Levels
            // Room One
        ROOM_ONE_BASE = new Texture("textures/room/one/terrainOne.png");
        ROOM_ONE_DEC = new Texture("textures/room/one/decorationsOne.png");
        // Ask about size...

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
            // Walk right and left
        ArrayList<TextureRegion> playerWalkRight = new ArrayList<>();
        ArrayList<TextureRegion> playerWalkLeft = new ArrayList<>();
        SpriteSheet playerWalkRightSheet = new SpriteSheet(new Texture(
                "textures/player/walk/walkingRight.png"),
                216, 275);
        SpriteSheet playerWalkLeftSheet = new SpriteSheet(new Texture(
                "textures/player/walk/walkingLeft.png"),
                216, 275);
        for(int i = 0; i < 30; i++) {
            playerWalkRight.add(playerWalkRightSheet.crop(i, 0));
            playerWalkLeft.add(playerWalkLeftSheet.crop(i, 0));
        }
        playerAnimations.add(new Animation(playerWalkRight, (short)1));
        playerAnimations.add(new Animation(playerWalkLeft, (short)1));
            // Idle
        ArrayList<TextureRegion> playerIdleRight = new ArrayList<>();
        ArrayList<TextureRegion> playerIdleLeft = new ArrayList<>();
        SpriteSheet playerIdleRightSheet = new SpriteSheet(new Texture(
                "textures/player/walk/idleRight.png"),
                178, 222);
        SpriteSheet playerIdleLeftSheet = new SpriteSheet(new Texture(
                "textures/player/walk/idleLeft.png"),
                178, 222);
        for(int i = 0; i < 30; i++) {
            playerIdleRight.add(playerIdleRightSheet.crop(i, 0));
            playerIdleLeft.add(playerIdleLeftSheet.crop(i, 0));
        }
        playerAnimations.add(new Animation(playerIdleRight, (short)1));
        playerAnimations.add(new Animation(playerIdleLeft, (short)1));
    }
}
