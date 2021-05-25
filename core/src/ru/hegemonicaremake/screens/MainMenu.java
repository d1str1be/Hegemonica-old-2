package ru.hegemonicaremake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.hegemonicaremake.HegeGame;

public class MainMenu implements Screen {
    
    HegeGame game;
    
    OrthographicCamera camera;
    Image bg;
    Sprite sprite;
    Stage stage;
    Viewport viewport;
    SpriteBatch batch;
    
    
    public MainMenu(HegeGame game) {
        this.game = game;
    }
    
    @Override
    public void show() {
        
        camera = new OrthographicCamera(HegeGame.width, HegeGame.height);
        viewport = new FitViewport(HegeGame.width, HegeGame.height, camera);
        stage = new Stage(viewport);
        bg = new Image(new Texture(Gdx.files.internal("bg.jpg")));
        batch = new SpriteBatch();
    }
    
    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.CLEAR, true);
        batch.begin();
        batch.draw(bg, 0, 0, HegeGame.width, HegeGame.height);
        batch.end();
    }
    
    @Override
    public void resize(int width, int height) {
        HegeGame.update();
    }
    
    @Override
    public void pause() {
    
    }
    
    @Override
    public void resume() {
    
    }
    
    @Override
    public void hide() {
    }
    
    @Override
    public void dispose() {
        batch.dispose();
    }
}
