package ru.hegemonicaremake.gameplay;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.hegemonicaremake.HegeGame;

public class PlayScreen implements Screen {
    HegeGame game;
    HegeMap map;
    
    public PlayScreen(HegeGame game) {
        this.game = game;
        map = new HegeMap(game);
    }
    
    @Override
    public void show() {
    
    }
    
    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.CLEAR);
        map.update();
        map.render();
        
    }
    
    @Override
    public void resize(int width, int height) {
    
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
    
    }
}
