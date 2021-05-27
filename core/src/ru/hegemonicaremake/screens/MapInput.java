package ru.hegemonicaremake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.hegemonicaremake.HegeLog;

public class MapInput implements GestureDetector.GestureListener {
    Stage stage;
    Viewport viewport;
    OrthographicCamera camera;
    
    InputMultiplexer im;
    
    HegeMap map;
    
    private final float zoomMin = 3f;
    private final float zoomMax = 0.25f;
    
    float realX;
    float realY;
    float cameraMovementX;
    float cameraMovementY;
    
    public MapInput(HegeMap map, OrthographicCamera camera, Viewport viewport) {
        
        this.camera = camera;
        this.viewport = viewport;
        this.map = map;
        stage = new Stage(viewport);
        
        camera.translate(0, 0);
        cameraMovementX = camera.viewportWidth / 2;
        cameraMovementY = -camera.viewportHeight / 2;
        camera.zoom = 0.25f;
        
        im = new InputMultiplexer();
        im.addProcessor(new GestureDetector(this));
        
        Gdx.input.setInputProcessor(im);
    }
    
    public void update() {
    }
    
    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }
    
    @Override
    public boolean tap(float x, float y, int count, int button) {
        HegeLog.log("Input", "Tapped on X: " + realX);
        HegeLog.log("Input", "Tapped on Y: " + realY);
        map.checkTap(x, y);
        return true;
    }
    
    @Override
    public boolean longPress(float x, float y) {
        return false;
    }
    
    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }
    
    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        cameraMovementX += deltaX;
        cameraMovementY += deltaY;
        camera.translate(-deltaX * camera.zoom, deltaY * camera.zoom);
        return false;
    }
    
    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }
    
    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }
    
    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }
    
    @Override
    public void pinchStop() {
    
    }
    
    
}
