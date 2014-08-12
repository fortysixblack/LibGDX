package com.me.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.me.game.MyGdxGame;
import com.me.game.MyJumpGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		new LwjglApplication(new MyGdxGame(), config);

        config.width = 480;
        config.height = 800;
        new LwjglApplication(new MyJumpGame(), config);
	}
}
