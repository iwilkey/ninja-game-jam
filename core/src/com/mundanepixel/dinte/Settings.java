package com.mundanepixel.dinte;

import com.badlogic.gdx.Input;

public class Settings {
    public static int
            // UI
            FONT_SIZE,

            // KEY BINDS
            MOVE_RIGHT,
            MOVE_LEFT;

    public static float UI_SCALE = 1;

    public static void init() {
        initDefaults();
    }

    private static void initDefaults() {
        // UI
        FONT_SIZE = 22;
        UI_SCALE = 1;

        // Settings
        MOVE_RIGHT = Input.Keys.D;
        MOVE_LEFT = Input.Keys.A;

    }
}
