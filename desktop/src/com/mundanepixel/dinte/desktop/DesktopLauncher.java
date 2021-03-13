package com.mundanepixel.dinte.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mundanepixel.dinte.Game;

import java.awt.*;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Ninja Game Jam: Death Is Not The End";
		config.height = size.height - 350;
		config.width = (int)(config.height * (16/9.0f));

		new LwjglApplication(new Game(), config);
	}
}
