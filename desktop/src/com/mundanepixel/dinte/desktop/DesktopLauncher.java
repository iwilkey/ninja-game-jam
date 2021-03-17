package com.mundanepixel.dinte.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mundanepixel.dinte.Game;

import java.awt.*;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Deadline";
		config.height = 900 - 350;
		config.width = (int)(config.height * (16/9.0f));
		new LwjglApplication(new Game(), config);
	}
}
