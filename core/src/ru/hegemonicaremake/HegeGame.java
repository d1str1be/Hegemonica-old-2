package ru.hegemonicaremake;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import ru.hegemonicaremake.utils.AudioManager;
import ru.hegemonicaremake.utils.Console;
import ru.hegemonicaremake.utils.HegeLog;
import ru.hegemonicaremake.utils.ScreenManager;
import ru.hegemonicaremake.utils.SkinManager;

public class HegeGame extends Game {
	public final static float VERSION = 0.2f;
	public final static boolean DEV_MODE = true;
	public static float width;
	public static float height;
	
	public AudioManager audio;
	public ScreenManager screenManager;
	public SkinManager skinManager;
	Console console;
	
	public HegeGame(){
	
	}
	@Override
	public void create () {
		Gdx.input.setCatchKey(Input.Keys.BACK, true);
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		HegeLog.log("Graphics","Width of app: " + width +
				"\nHeight of app: " + height);
		
		audio = new AudioManager();
		skinManager = new SkinManager();
		screenManager = new ScreenManager(this);
		console = new Console();
	}
	
	@Override
	public void render() {
		super.render();
	}
	
	@Override
	public void pause() {
		super.pause();
	}
	
	@Override
	public void resume() {
		super.resume();
	}
	
	@Override
	public void dispose () {
	}
	
	public static void update(){
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
	}
}
