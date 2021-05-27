package ru.hegemonicaremake.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.HegeLog;
import ru.hegemonicaremake.logic.LogicMain;
import ru.hegemonicaremake.logic.Province;

public class HegeMap {
    MapInput input;
    LogicMain logic;
    SpriteBatch batch;
    
    Viewport viewport;
    OrthographicCamera camera;
    
    public HegeMap() {
        logic = new LogicMain(LogicMain.MAPSIZEID.EXPERIMENTAL);
        batch = new SpriteBatch();
        camera = new OrthographicCamera(HegeGame.width, HegeGame.height);
        viewport = new StretchViewport(HegeGame.width, HegeGame.height, camera);
        input = new MapInput(this, camera, viewport);
    }
    
    public void render() {
        batch.setProjectionMatrix(camera.combined);
        for (Province prov : logic.provinces) {
            prov.render(batch);
        }
    }
    
    public void checkTap(float x, float y){
        if(logic.findTappedProvince(x,y)!=null){
            HegeLog.log("Input", "You`ve pressed " + logic.findTappedProvince(x,y).name);
        }
        
    }
}
