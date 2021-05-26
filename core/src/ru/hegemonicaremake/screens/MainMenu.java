package ru.hegemonicaremake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.hegemonicaremake.FontManager;
import ru.hegemonicaremake.HegeGame;

public class MainMenu implements Screen {
    
    HegeGame game;
    
    OrthographicCamera camera;
    Texture bgTexture;
    Image bg;
    Sprite sprite;
    Stage stage;
    Viewport viewport;
    SpriteBatch batch;
    Label label;
    TextButton button;
    
    public MainMenu(HegeGame game) {
        this.game = game;
    }
    
    @Override
    public void show() {
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.translate(camera.viewportWidth / 2, camera.viewportHeight / 2);
        viewport = new FitViewport(HegeGame.width, HegeGame.height, camera);
        stage = new Stage(viewport);
        
        bgTexture = new Texture(Gdx.files.internal("bg.jpg"));
        bg = new Image(bgTexture);
        bg.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        
        
        label = new Label("Hegemonica", new LabelStyle(FontManager.buildFont(Gdx.files.internal("fontsTTF/3947.ttf")), Color.WHITE));
        
        
        stage.addActor(bg);
        stage.addActor(label);
    }
    
    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.CLEAR);
        stage.act(delta);
        stage.draw();
    }
    
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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
