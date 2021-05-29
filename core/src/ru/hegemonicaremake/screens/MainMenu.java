package ru.hegemonicaremake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.hegemonicaremake.HegeGame;

public class MainMenu implements Screen {
    
    HegeGame game;
    
    ChooseMode chooseModeBtns;
    
    OrthographicCamera camera;
    Texture bgTexture;
    Image bg;
    Sprite sprite;
    Stage stage;
    Viewport viewport;
    SpriteBatch batch;
    Label label;
    TextButton bPlay;
    TextButton bExit;
    
    Table menuTable;
    
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
        
        label = new Label("Hegemonica", HegeGame.skinManager.timesNewRomanStyle);
        bPlay = new TextButton("Play", HegeGame.skinManager.shimmerSkin);
        bPlay.getLabel().setStyle(HegeGame.skinManager.mainMenuStyle);
        
        bPlay.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                chooseModeBtns.show(menuTable);
                stage.act();
            }
            
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        bExit = new TextButton("Exit", HegeGame.skinManager.shimmerSkin);
        bExit.getLabel().setStyle(HegeGame.skinManager.mainMenuStyle);
        bExit.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
            }
            
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        menuTable = new Table();
        menuTable.setSize(HegeGame.width * 0.6f, HegeGame.height * 0.5f);
        menuTable.setSize(HegeGame.width, HegeGame.height);
        menuTable.add(label);
        menuTable.center();
        menuTable.padBottom(HegeGame.height * 0.2f);
        menuTable.row();
        menuTable.add(bPlay).width(HegeGame.width * 0.5f).height(HegeGame.height * 0.2f);
        menuTable.row();
        menuTable.add(bExit).width(HegeGame.width * 0.5f).height(HegeGame.height * 0.2f);
        
        
        stage.addActor(bg);
        chooseModeBtns = new ChooseMode(game, stage);
        stage.addActor(menuTable);
        
        Gdx.input.setInputProcessor(stage);
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
        stage.dispose();
        batch.dispose();
    }
}
