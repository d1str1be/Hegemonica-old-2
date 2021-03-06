package ru.hegemonicaremake.gameplay;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.gameplay.notifications.CancelNotification;

public class PlayScreen implements Screen {
    HegeGame game;
    HegeMap map;
    public CancelNotification cancelNotification;
    
    public PlayScreen(HegeGame game, int mapSizeId) {
        this.game = game;
        map = new HegeMap(game, mapSizeId);
    }
    
    @Override
    public void show() {
    
    }
    
    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.CLEAR);
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
