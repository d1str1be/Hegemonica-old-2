package ru.hegemonicaremake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.hegemonicaremake.screens.MainMenu;

public class HegeGame extends Game {
	public final static float VERSION = 0.1f;
	public static float width;
	public static float height;
	
	Console console;
	
	@Override
	public void create () {
		this.setScreen(new MainMenu(this));
		console = new Console();
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
	}

	@Override
	public void render () {
		console.draw();
	}
	
	@Override
	public void dispose () {
	}
	
	public static void update(){
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
	}
}
