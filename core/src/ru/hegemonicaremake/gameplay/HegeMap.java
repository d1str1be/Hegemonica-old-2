package ru.hegemonicaremake.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.utils.HegeLog;

public class HegeMap {
    MapInput input;
    LogicMain logic;
    SpriteBatch batch;
    SpriteBatch bgBatch;
    Texture background;
    Viewport viewport;
    OrthographicCamera camera;
    
    Stage stage;
    
    public HegeMap() {
        batch = new SpriteBatch();
        bgBatch = new SpriteBatch();
        camera = new OrthographicCamera(HegeGame.width, HegeGame.height);
        viewport = new FitViewport(HegeGame.width, HegeGame.height, camera);

//        stage = new Stage(viewport, batch);
        logic = new LogicMain(LogicMain.MAPSIZEID.EXPERIMENTAL, this);
//        logic.initStage(stage);
        input = new MapInput(this, camera, viewport);
        background = new Texture(Gdx.files.internal("bg.jpg"));
    }
    
    public void render() {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        bgBatch.begin();
        bgBatch.draw(background, 0, 0, HegeGame.width, HegeGame.height);
        bgBatch.end();
        batch.begin();
        for (Province prov : logic.provinces) {
            prov.render(batch);
        }
        batch.end();
        
        
//        stage.act();
//        stage.draw();
    }

    public void update() {
        batch.begin();
        for (Province prov : logic.provinces) {
            prov.update(batch);
        }
        batch.end();
    }
    
    public void checkTap(float x, float y) {
        if (logic.findTappedProvince(x, y) != null) {
            HegeLog.log("Input", "You`ve pressed " + logic.findTappedProvince(x, y).name);
        }
    }
}
