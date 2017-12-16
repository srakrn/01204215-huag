package com.srakrn.dinojump.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.srakrn.dinojump.DinoJumpGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "DinoJump";
		config.height = 300;
		config.width = 900;
		new LwjglApplication(new DinoJumpGame(), config);
	}
}
