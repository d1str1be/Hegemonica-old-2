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
        map.render();
        map.update();
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
