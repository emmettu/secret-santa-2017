package com.emmett.tea.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.emmett.tea.Tea;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Tea Time";
		config.height = 540;
		config.width = 720;
		new LwjglApplication(new Tea(), config);
	}
}
