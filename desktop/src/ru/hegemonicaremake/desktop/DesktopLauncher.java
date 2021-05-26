package ru.hegemonicaremake.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.hegemonicaremake.HegeGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "HegemonicaRemake";
		config.vSyncEnabled = false;
		config.width = 1280;
		config.height = 720;
		config.fullscreen = false;
		config.addIcon("icons/hegemonicalogo32x32.png", Files.FileType.Internal);
		new LwjglApplication(new HegeGame(), config);
	}
}
